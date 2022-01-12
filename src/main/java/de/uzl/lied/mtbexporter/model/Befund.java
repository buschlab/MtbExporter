package de.uzl.lied.mtbexporter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "PID",
    "CBXEMPF_THERAP",
    "CBXEMPF_THERAP_KEIN_TARGET",
    "CBXEMPF_THERAP_POT_THERAPIEOP",
    "TXTBESCHLUSSWEITEREMASSNAHMEN",
    "EINGESCHR_PROBENQ_REEVAL_TEXT",
    "HUMANGEN_BERATUNG_EMPF_TEXT",
    "TXTTUMORBOARDBESCHLUSS"
})
public class Befund {

    @JsonProperty("PID")
    private String pid;
    @JsonProperty("CBXEMPF_THERAP")
    private Boolean empfTherap;
    @JsonProperty("CBXEMPF_THERAP_KEIN_TARGET")
    private Boolean empfTherapKeinTarget;
    @JsonProperty("CBXEMPF_THERAP_POT_THERAPIEOP")
    private Boolean empfTherapPotTherapieop;
    @JsonProperty("TXTBESCHLUSSWEITEREMASSNAHMEN")
    private String beschlussWeitereMassnahmen;
    @JsonProperty("REBIOPSIE_EMPFOHLEN_TEXT")
    private String rebiopsieEmpfohlenText = "nein";
    @JsonProperty("HUMANGEN_BERATUNG_EMPF_TEXT")
    private String humangenBeratungEmpfText = "nein";
    @JsonProperty("TXTTUMORBOARDBESCHLUSS")
    private String tumorboardbeschluss;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Boolean getEmpfTherap() {
        return empfTherap;
    }

    public void setEmpfTherap(Boolean empfTherap) {
        this.empfTherap = empfTherap;
    }

    public Boolean getEmpfTherapKeinTarget() {
        return empfTherapKeinTarget;
    }

    public void setEmpfTherapKeinTarget(Boolean empfTherapKeinTarget) {
        this.empfTherapKeinTarget = empfTherapKeinTarget;
    }

    public Boolean getEmpfTherapPotTherapieop() {
        return empfTherapPotTherapieop;
    }

    public void setEmpfTherapPotTherapieop(Boolean empfTherapPotTherapieop) {
        this.empfTherapPotTherapieop = empfTherapPotTherapieop;
    }

    public String getBeschlussWeitereMassnahmen() {
        return beschlussWeitereMassnahmen;
    }

    public void setBeschlussWeitereMassnahmen(String beschlussWeitereMassnahmen) {
        this.beschlussWeitereMassnahmen = beschlussWeitereMassnahmen;
    }

    public String getRebiopsieEmpfohlenText() {
        return rebiopsieEmpfohlenText;
    }

    public void setRebiopsieEmpfohlenText(String rebiopsieEmpfohlenText) {
        this.rebiopsieEmpfohlenText = rebiopsieEmpfohlenText;
    }

    public String getHumangenBeratungEmpfText() {
        return humangenBeratungEmpfText;
    }

    public void setHumangenBeratungEmpfText(String humangenBeratungEmpfText) {
        this.humangenBeratungEmpfText = humangenBeratungEmpfText;
    }

    public String getTumorboardbeschluss() {
        return tumorboardbeschluss;
    }

    public void setTumorboardbeschluss(String tumorboardbeschluss) {
        this.tumorboardbeschluss = tumorboardbeschluss;
    }

}
