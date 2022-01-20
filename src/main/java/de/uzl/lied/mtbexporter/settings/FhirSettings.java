package de.uzl.lied.mtbexporter.settings;

/**
 * Settings for FHIR server that will be used.
 */
public class FhirSettings {

    private String clinicalDataServerUrl;

    public String getClinicalDataServerUrl() {
        return clinicalDataServerUrl;
    }

    public void setClinicalDataServerUrl(String clinicalDataServerUrl) {
        this.clinicalDataServerUrl = clinicalDataServerUrl;
    }

}
