package de.uzl.lied.mtbexporter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Model for TKONF_MTB_Befund.
 */
@JsonPropertyOrder({
    "AUFTRAGSNUMMER_BEF",
    "PID",
    "CBXEMPF_DIAGN",
    "CBXEMPF_DIAGN_BIOPSIEN_ERF",
    "CBXEMPF_DIAGN_BLUTENTN_ERF",
    "CBXEMPF_DIAGN_WANGENABS_ERF",
    "CBXEMPF_THERAP",
    "CBXEMPF_THERAP_KEIN_TARGET",
    "CBXEMPF_THERAP_POT_THERAPIEOP",
    "TXTBESCHLUSSWEITEREMASSNAHMEN",
    "TXTEINGESCHR_PROBENQ_REEVAL",
    "TXTEMPFEHLUNG_DIAGNOSTIK",
    "TXTHUMANGEN_BERATUNG_EMPF",
    "TXTREBIOPSIE_EMPFOHLEN",
    "TXTTUMORBOARDBESCHLUSS",
    "TXTTUMORBOARDBESCHLUSS2",
    "TXTTUMORBOARDBESCHLUSS3",
    "TXTTUMORBOARDBESCHLUSS4",
    "TXTTUMORBOARDBESCHLUSS5",
    "TXTTUMORBOARDBESCHLUSS6",
    "TXTTUMORBOARDBESCHLUSS7",
    "TXTTUMORBOARDBESCHLUSS8"
})
public class Befund {

    @JsonProperty("PID")
    private String pid;
    @JsonProperty("CBXEMPF_DIAGN")
    private Boolean empfDiagn = false;
    @JsonProperty("CBXEMPF_DIAGN_BIOPSIEN_ERF")
    private Boolean empfDiagnBiopsienErf = false;
    @JsonProperty("CBXEMPF_DIAGN_BLUTENTN_ERF")
    private Boolean empfDiagnBlutentnErf = false;
    @JsonProperty("CBXEMPF_DIAGN_WANGENABS_ERF")
    private Boolean empfDiagnWangenabsErf = false;
    @JsonProperty("TXTEMPFEHLUNG_DIAGNOSTIK")
    private Boolean empfehlungDiagnostik = false;
    @JsonProperty("CBXEMPF_THERAP")
    private Boolean empfTherap = false;
    @JsonProperty("CBXEMPF_THERAP_KEIN_TARGET")
    private Boolean empfTherapKeinTarget = false;
    @JsonProperty("CBXEMPF_THERAP_POT_THERAPIEOP")
    private Boolean empfTherapPotTherapieop = false;
    @JsonProperty("AUFTRAGSNUMMER_BEF")
    private String auftragsnummerBef;
    @JsonProperty("TXTBESCHLUSSWEITEREMASSNAHMEN")
    private String beschlussWeitereMassnahmen;
    @JsonProperty("TXTEINGESCHR_PROBENQ_REEVAL")
    private String eingeschProbenQReevalText = "nein";
    @JsonProperty("TXTHUMANGEN_BERATUNG_EMPF")
    private String humangenBeratungEmpfText = "nein";
    @JsonProperty("TXTREBIOPSIE_EMPFOHLEN")
    private String rebiopsieEmpfohlenText = "nein";
    @JsonProperty("TXTTUMORBOARDBESCHLUSS")
    private String tumorboardbeschluss = "";
    @JsonProperty("TXTTUMORBOARDBESCHLUSS2")
    private String tumorboardbeschluss2 = "";
    @JsonProperty("TXTTUMORBOARDBESCHLUSS3")
    private String tumorboardbeschluss3 = "";
    @JsonProperty("TXTTUMORBOARDBESCHLUSS4")
    private String tumorboardbeschluss4 = "";
    @JsonProperty("TXTTUMORBOARDBESCHLUSS5")
    private String tumorboardbeschluss5 = "";
    @JsonProperty("TXTTUMORBOARDBESCHLUSS6")
    private String tumorboardbeschluss6 = "";
    @JsonProperty("TXTTUMORBOARDBESCHLUSS7")
    private String tumorboardbeschluss7 = "";
    @JsonProperty("TXTTUMORBOARDBESCHLUSS8")
    private String tumorboardbeschluss8 = "";

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
     * @return the auftragsnummerBef
     */
    public String getAuftragsnummerBef() {
        return auftragsnummerBef;
    }

    /**
     * @param auftragsnummerBef the auftragsnummerBef to set
     */
    public void setAuftragsnummerBef(String auftragsnummerBef) {
        this.auftragsnummerBef = auftragsnummerBef;
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

    /**
     * @return the tumorboardbeschluss2
     */
    public String getTumorboardbeschluss2() {
        return tumorboardbeschluss2;
    }

    /**
     * @param tumorboardbeschluss2 the tumorboardbeschluss2 to set
     */
    public void setTumorboardbeschluss2(String tumorboardbeschluss2) {
        this.tumorboardbeschluss2 = tumorboardbeschluss2;
    }

    /**
     * @return the tumorboardbeschluss3
     */
    public String getTumorboardbeschluss3() {
        return tumorboardbeschluss3;
    }

    /**
     * @param tumorboardbeschluss3 the tumorboardbeschluss3 to set
     */
    public void setTumorboardbeschluss3(String tumorboardbeschluss3) {
        this.tumorboardbeschluss3 = tumorboardbeschluss3;
    }

    /**
     * @return the tumorboardbeschluss4
     */
    public String getTumorboardbeschluss4() {
        return tumorboardbeschluss4;
    }

    /**
     * @param tumorboardbeschluss4 the tumorboardbeschluss4 to set
     */
    public void setTumorboardbeschluss4(String tumorboardbeschluss4) {
        this.tumorboardbeschluss4 = tumorboardbeschluss4;
    }

    /**
     * @return the tumorboardbeschluss5
     */
    public String getTumorboardbeschluss5() {
        return tumorboardbeschluss5;
    }

    /**
     * @param tumorboardbeschluss5 the tumorboardbeschluss5 to set
     */
    public void setTumorboardbeschluss5(String tumorboardbeschluss5) {
        this.tumorboardbeschluss5 = tumorboardbeschluss5;
    }

    /**
     * @return the tumorboardbeschluss6
     */
    public String getTumorboardbeschluss6() {
        return tumorboardbeschluss6;
    }

    /**
     * @param tumorboardbeschluss6 the tumorboardbeschluss6 to set
     */
    public void setTumorboardbeschluss6(String tumorboardbeschluss6) {
        this.tumorboardbeschluss6 = tumorboardbeschluss6;
    }

    /**
     * @return the tumorboardbeschluss7
     */
    public String getTumorboardbeschluss7() {
        return tumorboardbeschluss7;
    }

    /**
     * @param tumorboardbeschluss7 the tumorboardbeschluss7 to set
     */
    public void setTumorboardbeschluss7(String tumorboardbeschluss7) {
        this.tumorboardbeschluss7 = tumorboardbeschluss7;
    }

    /**
     * @return the tumorboardbeschluss8
     */
    public String getTumorboardbeschluss8() {
        return tumorboardbeschluss8;
    }

    /**
     * @param tumorboardbeschluss8 the tumorboardbeschluss8 to set
     */
    public void setTumorboardbeschluss8(String tumorboardbeschluss8) {
        this.tumorboardbeschluss8 = tumorboardbeschluss8;
    }

}
