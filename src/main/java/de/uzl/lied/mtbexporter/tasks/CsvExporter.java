package de.uzl.lied.mtbexporter.tasks;

import java.util.List;

import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.RelatedArtifact;
import org.hl7.fhir.r4.model.Task;
import org.hl7.fhir.r4.model.Observation.ObservationComponentComponent;

import de.uzl.lied.mtbexporter.model.BefTherapieoptionen;
import de.uzl.lied.mtbexporter.model.Befund;

public class CsvExporter {

    public static Befund exportDiagnosticReport(DiagnosticReport report, List<BefTherapieoptionen> beflist) {
        Befund befund = new Befund();
        befund.setPid(((Patient) report.getSubject().getResource()).getIdentifierFirstRep().getValue());

        befund.setBeschlussWeitereMassnahmen(report.getConclusion());

        int targets = 0;
        int i = 0;
        for (Reference r : report.getResult()) {
            Observation o = (Observation) r.getResource();
            if (!o.getMeta().getProfile().get(0).getValue()
                    .equals("http://hl7.org/fhir/uv/genomics-reporting/StructureDefinition/medication-efficacy")) {
                continue;
            }

            // String alteration = "Gen STK11 (PJS, LKB1), HGNC ID 11389, c.487G>C, p.G163R,
            // Variante unbekannt, Allelfrequenz 15.00%";
            String alteration = "";
            for (Reference rd : o.getDerivedFrom()) {
                Observation od = (Observation) rd.getResource();
                String variant = "";
                String gene = "";
                String hgnc = "";
                String phgvs = "";
                String allelfrequenz = "";

                for (ObservationComponentComponent oc : od.getComponent()) {
                    switch (oc.getCode().getCodingFirstRep().getCode()) {
                        case "48018-6":
                            gene = "Gen " + oc.getValueCodeableConcept().getCodingFirstRep().getDisplay();
                            hgnc = "HGNC ID "
                                    + oc.getValueCodeableConcept().getCodingFirstRep().getCode().replace("HGNC:", "");
                            break;
                        case "81258-6":
                            allelfrequenz = "Allelfrequenz " + oc.getValueQuantity().getValue().doubleValue() * 100
                                    + "%";
                            break;
                        case "48005-3":
                            phgvs = oc.getValueCodeableConcept().getCodingFirstRep().getCode();
                    }
                }

                variant = gene + ", " + hgnc + ", " + phgvs + ", " + allelfrequenz;
                alteration += variant + "<br>";
            }

            i++;

            BefTherapieoptionen bef = new BefTherapieoptionen();
            beflist.add(bef);
            bef.setPid(((Patient) report.getSubject().getResource()).getIdentifierFirstRep().getValue());
            bef.setStuetzendeMolekulareAlteration(alteration.substring(0, alteration.length() - 4));
            bef.setPrioritaet(i);

            for (ObservationComponentComponent oc : o.getComponent()) {
                switch (oc.getCode().getCodingFirstRep().getCode()) {
                    case "93044-6":
                        bef.setEvidenzLevel(oc.getValueCodeableConcept().getCodingFirstRep().getCode());
                        break;
                    case "51963-7":
                        bef.setWirkstoff(oc.getValueCodeableConcept().getCodingFirstRep().getCode());
                        targets++;
                        break;
                }
            }

            String pmids = "";
            for (Extension e : o.getExtensionsByUrl(
                    "http://hl7.org/fhir/uv/genomics-reporting/StructureDefinition/RelatedArtifact")) {
                pmids += ((RelatedArtifact) e.getValue()).getUrl().replaceFirst("https://www.ncbi.nlm.nih.gov/pubmed/",
                        "") + ", ";
            }
            bef.setPubmedIds(pmids.isEmpty() ? pmids : pmids.substring(0, pmids.length() - 2));
        }

        for (Extension e : report.getExtensionsByUrl(
                "http://hl7.org/fhir/uv/genomics-reporting/StructureDefinition/RecommendedAction")) {
            Task t = (Task) ((Reference) e.getValue()).getResource();
            if (t == null || !t.getMeta().getProfile().get(0)
                    .equals("http://hl7.org/fhir/uv/genomics-reporting/StructureDefinition/task-rec-followup")) {
                continue;
            }
            switch (t.getCode().getCodingFirstRep().getCode()) {
                case "LA14020-4":
                    befund.setHumangenBeratungEmpfText("ja");
                    break;
                case "LA14021-2":
                    befund.setRebiopsieEmpfohlenText("ja");
                    break;
            }
        }

        String beschluss = "<b>Therapieempfehlung:</b>";
        beschluss += targets > 0 ? "<br>potentielle Therapieoptionen<br>" : "";
        for (int j = 1; j <= beflist.size(); j++) {
            BefTherapieoptionen bef = beflist.get(j - 1);
            beschluss += "Nr." + j + " Therapie: Wirkstoff: " + bef.getWirkstoff() + " Evidenzlevel: "
                    + bef.getEvidenzLevel() + " PMID: " + bef.getPid() + " Prio: " + bef.getPrioritaet()
                    + "Stützende Molekulare Alteration:" + bef.getStuetzendeMolekulareAlteration() + "<br>";
        }

        befund.setTumorboardbeschluss(beschluss);

        befund.setEmpfTherap(i > 0);
        befund.setEmpfTherapKeinTarget(targets == 0);
        befund.setEmpfTherapPotTherapieop(targets > 0);

        return befund;

    }

}
