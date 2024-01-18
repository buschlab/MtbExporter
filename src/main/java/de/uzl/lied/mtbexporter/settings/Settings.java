package de.uzl.lied.mtbexporter.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

/**
 * Settings for MtbExporter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings({"checkstyle:HideUtilityClassConstructor"})
public class Settings {

    @JsonProperty("outputFolder")
    private static File outputFolder;
    @JsonProperty("cronIntervall")
    private static Integer cronIntervall;
    @JsonProperty("fhir")
    private static FhirSettings fhir;

    /**
     * Initializes settings object.
     * @param outputFolder
     * @param cronIntervall
     * @param fhir
     */
    public Settings(@JsonProperty("outputFolder") File outputFolder,
            @JsonProperty("cronIntervall") Integer cronIntervall, @JsonProperty("fhir") FhirSettings fhir) {
        Settings.outputFolder = outputFolder;
        Settings.cronIntervall = cronIntervall;
        Settings.fhir = fhir;
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

}
