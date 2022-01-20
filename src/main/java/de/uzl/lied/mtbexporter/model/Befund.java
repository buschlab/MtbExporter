package de.uzl.lied.mtbexporter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Model for TKONF_MTB_Befund.
 */
@JsonPropertyOrder({
    "PID",
    "CBXEMPF_DIAGN",
    "CBXEMPF_DIAGN_BIOPSIEN_ERF",
    "CBXEMPF_DIAGN_BLUTENTN_ERF",
    "CBXEMPF_DIAGN_WANGENABS_ERF",
    "TXTEMPFEHLUNG_DIAGNOSTIK",
    "CBXEMPF_THERAP",
    "CBXEMPF_THERAP_KEIN_TARGET",
    "CBXEMPF_THERAP_POT_THERAPIEOP",
    "TXTBESCHLUSSWEITEREMASSNAHMEN",
    "REBIOPSIE_EMPFOHLEN_TEXT",
    "HUMANGEN_BERATUNG_EMPF_TEXT",
    "REBIOPSIE_EMPFOHLEN_TEXT",
    "TXTTUMORBOARDBESCHLUSS"
})
public class Befund {

    @JsonProperty("PID")
    private String pid;
    @JsonProperty("CBXEMPF_DIAGN")
    private Boolean empfDiagn = false;
    @JsonProperty("CBXEMPF_DIAGN_BIOPSIEN_ERF")
    private Boolean empfDiagnBiopsienErf;
    @JsonProperty("CBXEMPF_DIAGN_BLUTENTN_ERF")
    private Boolean empfDiagnBlutentnErf = false;
    @JsonProperty("CBXEMPF_DIAGN_WANGENABS_ERF")
    private Boolean empfDiagnWangenabsErf = false;
    @JsonProperty("TXTEMPFEHLUNG_DIAGNOSTIK")
    private Boolean empfehlungDiagnostik;
    @JsonProperty("CBXEMPF_THERAP")
    private Boolean empfTherap = false;
    @JsonProperty("CBXEMPF_THERAP_KEIN_TARGET")
    private Boolean empfTherapKeinTarget = false;
    @JsonProperty("CBXEMPF_THERAP_POT_THERAPIEOP")
    private Boolean empfTherapPotTherapieop = false;
    @JsonProperty("TXTBESCHLUSSWEITEREMASSNAHMEN")
    private String beschlussWeitereMassnahmen;
    @JsonProperty("EINGESCHR_PROBENQ_REEVAL_TEXT")
    private String eingeschProbenQReevalText = "nein";
    @JsonProperty("HUMANGEN_BERATUNG_EMPF_TEXT")
    private String humangenBeratungEmpfText = "nein";
    @JsonProperty("REBIOPSIE_EMPFOHLEN_TEXT")
    private String rebiopsieEmpfohlenText = "nein";
    @JsonProperty("TXTTUMORBOARDBESCHLUSS")
    private String tumorboardbeschluss;

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the empfDiagn
     */
    public Boolean getEmpfDiagn() {
        return empfDiagn;
    }

    /**
     * @param empfDiagn the empfDiagn to set
     */
    public void setEmpfDiagn(Boolean empfDiagn) {
        this.empfDiagn = empfDiagn;
    }

    /**
     * @return the empfDiagnBiopsienErf
     */
    public Boolean getEmpfDiagnBiopsienErf() {
        return empfDiagnBiopsienErf;
    }

    /**
     * @param empfDiagnBiopsienErf the empfDiagnBiopsienErf to set
     */
    public void setEmpfDiagnBiopsienErf(Boolean empfDiagnBiopsienErf) {
        this.empfDiagnBiopsienErf = empfDiagnBiopsienErf;
    }

    /**
     * @return the empfDiagnBlutentnErf
     */
    public Boolean getEmpfDiagnBlutentnErf() {
        return empfDiagnBlutentnErf;
    }

    /**
     * @param empfDiagnBlutentnErf the empfDiagnBlutentnErf to set
     */
    public void setEmpfDiagnBlutentnErf(Boolean empfDiagnBlutentnErf) {
        this.empfDiagnBlutentnErf = empfDiagnBlutentnErf;
    }

    /**
     * @return the empfDiagnWangenabsErf
     */
    public Boolean getEmpfDiagnWangenabsErf() {
        return empfDiagnWangenabsErf;
    }

    /**
     * @param empfDiagnWangenabsErf the empfDiagnWangenabsErf to set
     */
    public void setEmpfDiagnWangenabsErf(Boolean empfDiagnWangenabsErf) {
        this.empfDiagnWangenabsErf = empfDiagnWangenabsErf;
    }

    /**
     * @return the empfehlungDiagnostik
     */
    public Boolean getEmpfehlungDiagnostik() {
        return empfehlungDiagnostik;
    }

    /**
     * @param empfehlungDiagnostik the empfehlungDiagnostik to set
     */
    public void setEmpfehlungDiagnostik(Boolean empfehlungDiagnostik) {
        this.empfehlungDiagnostik = empfehlungDiagnostik;
    }

    /**
     * @return the empfTherap
     */
    public Boolean getEmpfTherap() {
        return empfTherap;
    }

    /**
     * @param empfTherap the empfTherap to set
     */
    public void setEmpfTherap(Boolean empfTherap) {
        this.empfTherap = empfTherap;
    }

    /**
     * @return the empfTherapKeinTarget
     */
    public Boolean getEmpfTherapKeinTarget() {
        return empfTherapKeinTarget;
    }

    /**
     * @param empfTherapKeinTarget the empfTherapKeinTarget to set
     */
    public void setEmpfTherapKeinTarget(Boolean empfTherapKeinTarget) {
        this.empfTherapKeinTarget = empfTherapKeinTarget;
    }

    /**
     * @return the empfTherapPotTherapieop
     */
    public Boolean getEmpfTherapPotTherapieop() {
        return empfTherapPotTherapieop;
    }

    /**
     * @param empfTherapPotTherapieop the empfTherapPotTherapieop to set
     */
    public void setEmpfTherapPotTherapieop(Boolean empfTherapPotTherapieop) {
        this.empfTherapPotTherapieop = empfTherapPotTherapieop;
    }

    /**
     * @return the beschlussWeitereMassnahmen
     */
    public String getBeschlussWeitereMassnahmen() {
        return beschlussWeitereMassnahmen;
    }

    /**
     * @param beschlussWeitereMassnahmen the beschlussWeitereMassnahmen to set
     */
    public void setBeschlussWeitereMassnahmen(String beschlussWeitereMassnahmen) {
        this.beschlussWeitereMassnahmen = beschlussWeitereMassnahmen;
    }

    /**
     * @return the eingeschProbenQReevalText
     */
    public String getEingeschProbenQReevalText() {
        return eingeschProbenQReevalText;
    }

    /**
     * @param eingeschProbenQReevalText the eingeschProbenQReevalText to set
     */
    public void setEingeschProbenQReevalText(String eingeschProbenQReevalText) {
        this.eingeschProbenQReevalText = eingeschProbenQReevalText;
    }

    /**
     * @return the humangenBeratungEmpfText
     */
    public String getHumangenBeratungEmpfText() {
        return humangenBeratungEmpfText;
    }

    /**
     * @param humangenBeratungEmpfText the humangenBeratungEmpfText to set
     */
    public void setHumangenBeratungEmpfText(String humangenBeratungEmpfText) {
        this.humangenBeratungEmpfText = humangenBeratungEmpfText;
    }

    /**
     * @return the rebiopsieEmpfohlenText
     */
    public String getRebiopsieEmpfohlenText() {
        return rebiopsieEmpfohlenText;
    }

    /**
     * @param rebiopsieEmpfohlenText the rebiopsieEmpfohlenText to set
     */
    public void setRebiopsieEmpfohlenText(String rebiopsieEmpfohlenText) {
        this.rebiopsieEmpfohlenText = rebiopsieEmpfohlenText;
    }

    /**
     * @return the tumorboardbeschluss
     */
    public String getTumorboardbeschluss() {
        return tumorboardbeschluss;
    }

    /**
     * @param tumorboardbeschluss the tumorboardbeschluss to set
     */
    public void setTumorboardbeschluss(String tumorboardbeschluss) {
        this.tumorboardbeschluss = tumorboardbeschluss;
    }

}
