package de.uzl.lied.mtbexporter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Model for TKONF_MTB_Bef_Therapieoptionen.
 */
@JsonPropertyOrder({
    "AUFTRAGSNUMMER_BEF",
    "PID",
    "CBXEVIDENZLEVEL_R",
    "CBXEVIDL_M1_ZUL_Z_EMA",
    "CBXEVIDL_M1_ZUL_Z_FDA",
    "CBXEVIDENZLEVEL_M3_IN_SITU",
    "CBXEVIDENZLEVEL_M3_IN_VITRO",
    "TXTPMID",
    "GZPRIORISIERUNG",
    "TXTEVIDENZLEVEL_M3_FREITEXT",
    "TXTSTUETZENDE_MOLEKULARE_ALTER",
    "TXTTHERAPIE",
    "TXTEVIDENZLEVEL",
    "TXTWIRKSTOFF",
    "TXTKLINISCHE_STUDIE_NCT_DRKS_S",
    "CBXEVIDENZLEVEL_NICHT_BIOMARKE"
})
public class BefTherapieoptionen {

    @JsonProperty("AUFTRAGSNUMMER_BEF")
    private String auftragsnummerBef;
    @JsonProperty("PID")
    private String pid;
    @JsonProperty("CBXEVIDENZLEVEL_R")
    private Boolean evidenzlevelR = false;
    @JsonProperty("CBXEVIDL_M1_ZUL_Z_EMA")
    private Boolean evidenzlevelM1ZulEma = false;
    @JsonProperty("CBXEVIDL_M1_ZUL_Z_FDA")
    private Boolean evidenzlevelM1ZulFda = false;
    @JsonProperty("CBXEVIDENZLEVEL_M3_IN_SITU")
    private Boolean evidenzlevelM3InSitu = false;
    @JsonProperty("CBXEVIDENZLEVEL_M3_IN_VITRO")
    private Boolean evidenzlevelM3InVitro = false;
    @JsonProperty("GZPRIORISIERUNG")
    private Integer prioritaet;
    @JsonProperty("TXTEVIDENZLEVEL_M3_FREITEXT")
    private String evidenzlevelM3Freitext;
    @JsonProperty("TXTSTUETZENDE_MOLEKULARE_ALTER")
    private String stuetzendeMolekulareAlteration = "";
    @JsonProperty("TXTTHERAPIE")
    private String therapie = "";
    @JsonProperty("TXTEVIDENZLEVEL")
    private String evidenzLevel;
    @JsonProperty("TXTWIRKSTOFF")
    private String wirkstoff;
    @JsonProperty("TXTPMID")
    private String pubmedIds;
    @JsonProperty("TXTKLINISCHE_STUDIE_NCT_DRKS_S")
    private String registrierungsnummer;
    @JsonProperty("CBXEVIDENZLEVEL_NICHT_BIOMARKE")
    private Boolean evidenzlevelNichtBiomarker = false;
    @JsonIgnore
    private String note;
    @JsonIgnore
    private String evidenzlevelText;

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
     * @return the evidenzlevelR
     */
    public Boolean getEvidenzlevelR() {
        return evidenzlevelR;
    }

    /**
     * @param evidenzlevelR the evidenzlevelR to set
     */
    public void setEvidenzlevelR(Boolean evidenzlevelR) {
        this.evidenzlevelR = evidenzlevelR;
    }

    /**
     * @return the evidenzlevelM1ZulEma
     */
    public Boolean getEvidenzlevelM1ZulEma() {
        return evidenzlevelM1ZulEma;
    }

    /**
     * @param evidenzlevelM1ZulEma the evidenzlevelM1ZulEma to set
     */
    public void setEvidenzlevelM1ZulEma(Boolean evidenzlevelM1ZulEma) {
        this.evidenzlevelM1ZulEma = evidenzlevelM1ZulEma;
    }

    /**
     * @return the evidenzlevelM1ZulFda
     */
    public Boolean getEvidenzlevelM1ZulFda() {
        return evidenzlevelM1ZulFda;
    }

    /**
     * @param evidenzlevelM1ZulFda the evidenzlevelM1ZulFda to set
     */
    public void setEvidenzlevelM1ZulFda(Boolean evidenzlevelM1ZulFda) {
        this.evidenzlevelM1ZulFda = evidenzlevelM1ZulFda;
    }

    /**
     * @return the evidenzlevelM3InSitu
     */
    public Boolean getEvidenzlevelM3InSitu() {
        return evidenzlevelM3InSitu;
    }

    /**
     * @param evidenzlevelM3InSitu the evidenzlevelM3InSitu to set
     */
    public void setEvidenzlevelM3InSitu(Boolean evidenzlevelM3InSitu) {
        this.evidenzlevelM3InSitu = evidenzlevelM3InSitu;
    }

    /**
     * @return the evidenzlevelM3InVitro
     */
    public Boolean getEvidenzlevelM3InVitro() {
        return evidenzlevelM3InVitro;
    }

    /**
     * @param evidenzlevelM3InVitro the evidenzlevelM3InVitro to set
     */
    public void setEvidenzlevelM3InVitro(Boolean evidenzlevelM3InVitro) {
        this.evidenzlevelM3InVitro = evidenzlevelM3InVitro;
    }

    /**
     * @return the prioritaet
     */
    public Integer getPrioritaet() {
        return prioritaet;
    }

    /**
     * @param prioritaet the prioritaet to set
     */
    public void setPrioritaet(Integer prioritaet) {
        this.prioritaet = prioritaet;
    }

    /**
     * @return the evidenzlevelM3Freitext
     */
    public String getEvidenzlevelM3Freitext() {
        return evidenzlevelM3Freitext;
    }

    /**
     * @param evidenzlevelM3Freitext the evidenzlevelM3Freitext to set
     */
    public void setEvidenzlevelM3Freitext(String evidenzlevelM3Freitext) {
        this.evidenzlevelM3Freitext = evidenzlevelM3Freitext;
    }

    /**
     * @return the stuetzendeMolekulareAlteration
     */
    public String getStuetzendeMolekulareAlteration() {
        return stuetzendeMolekulareAlteration;
    }

    /**
     * @param stuetzendeMolekulareAlteration the stuetzendeMolekulareAlteration to set
     */
    public void setStuetzendeMolekulareAlteration(String stuetzendeMolekulareAlteration) {
        this.stuetzendeMolekulareAlteration = stuetzendeMolekulareAlteration;
    }

    /**
     * @return the therapie
     */
    public String getTherapie() {
        return therapie;
    }

    /**
     * @param therapie the therapie to set
     */
    public void setTherapie(String therapie) {
        this.therapie = therapie;
    }

    /**
     * @return the evidenzLevel
     */
    public String getEvidenzLevel() {
        return evidenzLevel;
    }

    /**
     * @param evidenzLevel the evidenzLevel to set
     */
    public void setEvidenzLevel(String evidenzLevel) {
        this.evidenzLevel = evidenzLevel;
    }

    /**
     * @return the wirkstoff
     */
    public String getWirkstoff() {
        return wirkstoff;
    }

    /**
     * @param wirkstoff the wirkstoff to set
     */
    public void setWirkstoff(String wirkstoff) {
        if (this.wirkstoff == null || this.wirkstoff.isEmpty()) {
            this.wirkstoff = wirkstoff;
        } else {
            this.wirkstoff += " + " + wirkstoff;
        }
    }

    /**
     * @return the pubmedIds
     */
    public String getPubmedIds() {
        return pubmedIds;
    }

    /**
     * @param pubmedIds the pubmedIds to set
     */
    public void setPubmedIds(String pubmedIds) {
        this.pubmedIds = pubmedIds;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the evidenzlevelText
     */
    public String getEvidenzlevelText() {
        return evidenzlevelText;
    }

    /**
     * @param evidenzlevelText the evidenzlevelText to set
     */
    public void setEvidenzlevelText(String evidenzlevelText) {
        this.evidenzlevelText = evidenzlevelText;
    }

    /**
     * @return the registrierungsnummer
     */
    public String getRegistrierungsnummer() {
        return registrierungsnummer;
    }

    /**
     * @param registrierungsnummer the registrierungsnummer to set
     */
    public void setRegistrierungsnummer(String registrierungsnummer) {
        this.registrierungsnummer = registrierungsnummer;
    }

    /**
     * @return the evidenzlevelNichtBiomarker
     */
    public Boolean getEvidenzlevelNichtBiomarker() {
        return evidenzlevelNichtBiomarker;
    }

    /**
     * @param evidenzlevelNichtBiomarker the evidenzlevelNichtBiomarker to set
     */
    public void setEvidenzlevelNichtBiomarker(Boolean evidenzlevelNichtBiomarker) {
        this.evidenzlevelNichtBiomarker = evidenzlevelNichtBiomarker;
    }

}
