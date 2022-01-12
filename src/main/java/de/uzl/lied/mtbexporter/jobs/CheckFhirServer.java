package de.uzl.lied.mtbexporter.jobs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.common.io.ByteStreams;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.gclient.TokenClientParam;
import ca.uhn.fhir.rest.param.DateParam;
import ca.uhn.fhir.rest.param.DateRangeParam;
import ca.uhn.fhir.rest.param.ParamPrefixEnum;
import de.uzl.lied.mtbexporter.model.BefTherapieoptionen;
import de.uzl.lied.mtbexporter.model.Befund;
import de.uzl.lied.mtbexporter.settings.Settings;
import de.uzl.lied.mtbexporter.tasks.CsvExporter;

public class CheckFhirServer extends TimerTask {

    FhirContext ctx = FhirContext.forR4();
    private static IGenericClient cdrClient;

    public CheckFhirServer() {
        cdrClient = ctx.newRestfulGenericClient(Settings.getFhir().getClinicalDataServerUrl());
    }

    @Override
    public void run() {

        long state = 0;
        try {
            InputStream stateStream = new FileInputStream(".state");
            state = Long.parseLong(new String(ByteStreams.toByteArray(stateStream)));
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Date d0 = new Date(state);
        Date d = new Date();

        System.out.println("Checking for new data on FHIR server!");

        Bundle b = (Bundle) cdrClient.search().forResource(DiagnosticReport.class)
                .where(new TokenClientParam("status").exactly().code("final"))
                .include(new Include("DiagnosticReport:subject"))
                .include(new Include("DiagnosticReport:result"))
                .include(new Include("DiagnosticReport:performer"))
                .include(new Include("DiagnosticReport:specimen"))
                .include(new Include("Observation:performer", true))
                .lastUpdated(new DateRangeParam(new DateParam(ParamPrefixEnum.GREATERTHAN, d0)))
                .execute();

        if (b.hasEntry()) {
            System.out.println("Found " + b.getTotal() + " new reports!");
            List<Befund> befunde = new ArrayList<Befund>();
            List<BefTherapieoptionen> befTherapieoptionen = new ArrayList<BefTherapieoptionen>();
            for (BundleEntryComponent entry : b.getEntry()) {
                if (entry.getResource() instanceof DiagnosticReport) {
                    DiagnosticReport report = (DiagnosticReport) entry.getResource();
                    System.out.println("Starting proceccing of " + report.getId());
                    befunde.add(CsvExporter.exportDiagnosticReport(report, befTherapieoptionen));
                } else {
                    System.out.println("Skipping resource of type " + entry.getResource().getResourceType().toString());
                }
            }

            String filenameBefunde = "TKONF_MTB_Befund_" + d.getTime() + ".csv";
            String filenameTherapieoptionen = "TKONF_MTB_Bef_Therapieoptionen_" + d.getTime() + ".csv";
            CsvMapper om = new CsvMapper();
            om.configOverride(Boolean.class).setFormat(JsonFormat.Value.forShape(JsonFormat.Shape.NUMBER));
            CsvSchema s = om.schemaFor(Befund.class).withHeader().withColumnSeparator(';')
                    .withoutQuoteChar();
            CsvSchema s2 = om.schemaFor(BefTherapieoptionen.class).withHeader().withColumnSeparator(';')
                    .withoutQuoteChar();
            try {
                om.writer(s).writeValue(new File(Settings.getOutputFolder() + "/" + filenameBefunde), befunde);
                om.writer(s2).writeValue(new File(Settings.getOutputFolder() + "/" + filenameTherapieoptionen),
                        befTherapieoptionen);

                FileOutputStream fos = new FileOutputStream(".state");
                fos.write(String.valueOf(d.getTime()).getBytes());
                fos.close();
                System.out.println("Finished processing of " + b.getTotal() + " reports.");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        } else {
            System.out.println("No new data on FHIR server.");
        }
    }

}
