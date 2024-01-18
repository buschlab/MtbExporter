package de.uzl.lied.mtbexporter.jobs;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.gclient.TokenClientParam;
import ca.uhn.fhir.rest.param.DateParam;
import ca.uhn.fhir.rest.param.DateRangeParam;
import ca.uhn.fhir.rest.param.ParamPrefixEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.common.io.ByteStreams;
import de.uzl.lied.mtbexporter.model.BefTherapieoptionen;
import de.uzl.lied.mtbexporter.model.Befund;
import de.uzl.lied.mtbexporter.settings.Settings;
import de.uzl.lied.mtbexporter.tasks.CsvExporter;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Observation;
import org.tinylog.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 * Job that is triggerd to check the FHIR server and start the export.
 */
@SuppressWarnings({"checkstyle:MagicNumber"})
public class CheckFhirServer extends TimerTask {

    private static IGenericClient cdrClient = FhirContext.forR4()
            .newRestfulGenericClient(Settings.getFhir().getClinicalDataServerUrl());

    @Override
    public void run() {

        cdrClient.getFhirContext().getRestfulClientFactory().setConnectTimeout(120 * 1000);
        cdrClient.getFhirContext().getRestfulClientFactory().setSocketTimeout(120 * 1000);

        long state = 0;
        try {
            InputStream stateStream = new FileInputStream(".state");
            state = Long.parseLong(new String(ByteStreams.toByteArray(stateStream)));
        } catch (NumberFormatException | IOException e) {
            Logger.error(e, "Error reading state file!");
        }
        Date d0 = new Date(state);
        Date d = new Date();

        Logger.debug("Checking for new data on FHIR server!");

        Bundle b = (Bundle) cdrClient.search().forResource(DiagnosticReport.class)
                .where(new TokenClientParam("status").exactly().code("final"))
                .include(DiagnosticReport.INCLUDE_BASED_ON)
                .include(DiagnosticReport.INCLUDE_SUBJECT)
                .include(DiagnosticReport.INCLUDE_RESULT)
                .include(DiagnosticReport.INCLUDE_PERFORMER)
                .include(DiagnosticReport.INCLUDE_SPECIMEN)
                .include(Observation.INCLUDE_PERFORMER.asRecursive())
                .lastUpdated(new DateRangeParam(new DateParam(ParamPrefixEnum.GREATERTHAN, d0)))
                .count(32768)
                .execute();

        if (!b.hasEntry()) {
            Logger.debug("No new data on FHIR server.");
            return;
        }
        Logger.info("Found " + b.getTotal() + " new reports!");
        List<Befund> befunde = new ArrayList<>();
        List<BefTherapieoptionen> befTherapieoptionen = new ArrayList<>();
        b.getEntry().forEach(entry -> {
            if (entry.getResource() instanceof DiagnosticReport) {
                DiagnosticReport report = (DiagnosticReport) entry.getResource();
                Logger.debug("Starting proceccing of " + report.getId());
                befunde.add(CsvExporter.exportDiagnosticReport(report, befTherapieoptionen));
            } else {
                Logger.warn("Skipping resource of type " + entry.getResource().getResourceType().toString());
            }
        });

        String filenameBefunde = "TKONF_MTB_Befund_" + d.getTime() + ".csv";
        String filenameTherapieoptionen = "TKONF_MTB_Bef_Therapieoptionen_" + d.getTime() + ".csv";
        CsvMapper om = new CsvMapper();
        om.configOverride(Boolean.class).setFormat(JsonFormat.Value.forShape(JsonFormat.Shape.NUMBER));
        CsvSchema s = om.schemaFor(Befund.class).withHeader().withColumnSeparator(';')
                .withoutQuoteChar().withLineSeparator("\r\n");
        CsvSchema s2 = om.schemaFor(BefTherapieoptionen.class).withHeader().withColumnSeparator(';')
                .withoutQuoteChar().withLineSeparator("\r\n");
        try (FileOutputStream fos = new FileOutputStream(".state")) {
            om.writer(s).writeValue(new File(Settings.getOutputFolder(), filenameBefunde), befunde);
            om.writer(s2).writeValue(new File(Settings.getOutputFolder(), filenameTherapieoptionen),
                    befTherapieoptionen);

            fos.write(String.valueOf(d.getTime()).getBytes());
            Logger.info("Finished processing of " + b.getTotal() + " reports.");
        } catch (IOException e) {
            Logger.error(e, "Error writing report!");
        }
    }

}
