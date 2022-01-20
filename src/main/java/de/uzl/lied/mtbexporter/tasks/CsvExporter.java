package de.uzl.lied.mtbexporter.tasks;

import de.uzl.lied.mtbexporter.model.BefTherapieoptionen;
import de.uzl.lied.mtbexporter.model.Befund;
import de.uzl.lied.mtbexporter.model.internal.Alteration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.RelatedArtifact;
import org.hl7.fhir.r4.model.Task;

/**
 * Exporter for FHIR IG Genomics-Reporting to UKSH Orbis TKONF MTB form.
 */
public final class CsvExporter {

    private static final int PERCENT = 100;
    private static final int ALTERATION_SUFFIX_LENGTH = 4;
    private static final String RELATEDARTIFACT_URI =
        "http://hl7.org/fhir/uv/genomics-reporting/StructureDefinition/RelatedArtifact";
    private static final String FOLLOWUP_URI =
        "http://hl7.org/fhir/uv/genomics-reporting/StructureDefinition/task-rec-followup";
    private static final String RECOMMENDEDACTION_URI =
        "http://hl7.org/fhir/uv/genomics-reporting/StructureDefinition/RecommendedAction";
    private static final String MEDICATIONEFFICACY_URI =
        "http://hl7.org/fhir/uv/genomics-reporting/StructureDefinition/medication-efficacy";

    private CsvExporter() {
    }

    /**
     * Exports FHIR DiagnosticReport to a JVM modeled Befund object.
     *
     * @param report  FHIR resource with a DiagnosticReport
     * @param beflist List of therapy options as a partial result
     * @return FHIR resource exported to a JVM Befund object
     */
    public static Befund exportDiagnosticReport(DiagnosticReport report, List<BefTherapieoptionen> beflist) {
        Befund befund = new Befund();
        befund.setPid(((Patient) report.getSubject().getResource()).getIdentifierFirstRep().getValue());

        befund.setBeschlussWeitereMassnahmen(report.getConclusion());

        AtomicInteger targets = new AtomicInteger(0);
        AtomicInteger i = new AtomicInteger(0);
        report.getResult().forEach(r -> {
            Observation o = (Observation) r.getResource();
            if (!o.getMeta().getProfile().get(0).getValue()
                    .equals(MEDICATIONEFFICACY_URI)) {
                return;
            }

            String alteration = "";
            for (Reference rd : o.getDerivedFrom()) {
                Observation od = (Observation) rd.getResource();
                Alteration a = new Alteration();

                od.getComponent().forEach(oc -> {
                    switch (oc.getCode().getCodingFirstRep().getCode()) {
                        case "48018-6":
                            a.setGene(oc.getValueCodeableConcept().getCodingFirstRep().getDisplay());
                            a.setHgnc(oc.getValueCodeableConcept().getCodingFirstRep().getCode().replace("HGNC:", ""));
                            break;
                        case "81258-6":
                            a.setAllelfrequenz(oc.getValueQuantity().getValue().doubleValue() * PERCENT);
                            break;
                        case "48005-3":
                            a.setpHgvs(oc.getValueCodeableConcept().getCodingFirstRep().getCode());
                            break;
                        default:
                            break;
                    }
                });
                alteration += a.toString() + "<br>";
            }
            i.incrementAndGet();

            BefTherapieoptionen bef = new BefTherapieoptionen();
            beflist.add(bef);
            bef.setPid(((Patient) report.getSubject().getResource()).getIdentifierFirstRep().getValue());
            if (!alteration.isEmpty()) {
                bef.setStuetzendeMolekulareAlteration(
                    alteration.substring(0, alteration.length() - ALTERATION_SUFFIX_LENGTH));
            }
            bef.setPrioritaet(i.get());
            o.getComponent().forEach(oc -> {
                switch (oc.getCode().getCodingFirstRep().getCode()) {
                    case "93044-6":
                        String[] evidence = oc.getValueCodeableConcept().getCodingFirstRep().getCode().split(" ");
                        if (evidence.length > 1) {
                            bef.setEvidenzLevel(evidence[0]);
                            switch (evidence[1]) {
                                case "Z(EMA)":
                                    bef.setEvidenzlevelM1ZulEma(true);
                                    break;
                                case "F(FDA)":
                                    bef.setEvidenzlevelM1ZulFda(true);
                                    break;
                                case "is":
                                    bef.setEvidenzlevelM3InSitu(true);
                                    break;
                                case "iv":
                                    bef.setEvidenzlevelM3InVitro(true);
                                    break;
                                case "R":
                                    bef.setEvidenzlevelR(true);
                                    break;
                                default:
                                    break;
                            }
                            if (evidence.length > 2) {
                                bef.setEvidenzlevelM3Freitext(
                                        String.join(" ", Arrays.asList(evidence).subList(2, evidence.length))
                                                .replace("(", "").replace(")", ""));
                            }
                        } else {
                            bef.setEvidenzLevel(oc.getValueCodeableConcept().getCodingFirstRep().getCode());
                        }
                        break;
                    case "51963-7":
                        bef.setWirkstoff(oc.getValueCodeableConcept().getCodingFirstRep().getCode());
                        targets.incrementAndGet();
                        break;
                    default:
                        break;
                }
            });

            String pmids = "";
            for (Extension e : o.getExtensionsByUrl(RELATEDARTIFACT_URI)) {
                pmids += ((RelatedArtifact) e.getValue()).getUrl().replaceFirst("https://www.ncbi.nlm.nih.gov/pubmed/",
                        "") + ", ";
            }
            bef.setPubmedIds(pmids.isEmpty() ? pmids : pmids.substring(0, pmids.length() - 2));
        });

        report.getExtensionsByUrl(RECOMMENDEDACTION_URI).forEach(e -> {
            Task t = (Task) ((Reference) e.getValue()).getResource();
            if (t == null || !t.getMeta().getProfile().get(0)
                    .equals(FOLLOWUP_URI)) {
                return;
            }
            switch (t.getCode().getCodingFirstRep().getCode()) {
                case "LA14020-4":
                    befund.setHumangenBeratungEmpfText("ja");
                    break;
                case "LA14021-2":
                    befund.setRebiopsieEmpfohlenText("ja");
                    break;
                default:
                    break;
            }
        });

        String beschluss = "<b>Therapieempfehlung:</b>";
        beschluss += targets.get() > 0 ? "<br>potentielle Therapieoptionen<br>" : "";
        for (int j = 1; j <= beflist.size(); j++) {
            BefTherapieoptionen bef = beflist.get(j - 1);
            beschluss += "Nr." + j + " Therapie: Wirkstoff: " + bef.getWirkstoff() + " Evidenzlevel: "
                    + bef.getEvidenzLevel() + " PMID: " + bef.getPid() + " Prio: " + bef.getPrioritaet()
                    + "Stützende Molekulare Alteration:" + bef.getStuetzendeMolekulareAlteration() + "<br>";
        }

        befund.setTumorboardbeschluss(beschluss);

        befund.setEmpfTherap(i.get() > 0);
        befund.setEmpfTherapKeinTarget(targets.get() == 0);
        befund.setEmpfTherapPotTherapieop(targets.get() > 0);

        return befund;

    }

}
