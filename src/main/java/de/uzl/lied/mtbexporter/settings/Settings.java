package de.uzl.lied.mtbexporter.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import java.util.List;

/**
 * Settings for MtbExporter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Settings {

    @JsonProperty("outputFolder")
    private static File outputFolder;
    @JsonProperty("cronIntervall")
    private static Integer cronIntervall;
    @JsonProperty("fhir")
    private static FhirSettings fhir;
    @JsonProperty("regex")
    private static List<Regex> regex;

    /**
     * Initializes settings object.
     * @param outputFolder
     * @param cronIntervall
     * @param fhir
     * @param regex
     */
    public Settings(@JsonProperty("outputFolder") File outputFolder,
            @JsonProperty("cronIntervall") Integer cronIntervall, @JsonProperty("fhir") FhirSettings fhir,
            @JsonProperty("regex") List<Regex> regex) {
        Settings.outputFolder = outputFolder;
        Settings.cronIntervall = cronIntervall;
        Settings.fhir = fhir;
        Settings.regex = regex;
    }

    public static File getOutputFolder() {
        return outputFolder;
    }

    public static Integer getCronIntervall() {
        return cronIntervall;
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

}
