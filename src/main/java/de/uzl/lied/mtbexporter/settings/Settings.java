package de.uzl.lied.mtbexporter.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Settings for MtbExporter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Settings {

    @JsonProperty("outputFolder")
    private static String outputFolder;
    @JsonProperty("cronIntervall")
    private static Integer cronIntervall;
    @JsonProperty("fhir")
    private static FhirSettings fhir;
    @JsonProperty("regex")
    private static List<Regex> regex;

    public static String getOutputFolder() {
        return outputFolder;
    }

    @JsonProperty("outputFolder")
    public void setOutputFolder(String newOutputFolder) {
        outputFolder = newOutputFolder;
    }

    public static Integer getCronIntervall() {
        return cronIntervall;
    }

    @JsonProperty("cronIntervall")
    public void setCronItnervall(Integer newCronIntervall) {
        cronIntervall = newCronIntervall;
    }

    public static FhirSettings getFhir() {
        return fhir;
    }

    @JsonProperty("fhir")
    public void setFhir(FhirSettings newFhir) {
        fhir = newFhir;
    }

    public static List<Regex> getRegex() {
        return regex;
    }

    @JsonProperty("regex")
    public void setRegex(List<Regex> newRegex) {
        regex = newRegex;
    }

}
