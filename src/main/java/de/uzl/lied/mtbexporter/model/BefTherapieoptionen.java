package de.uzl.lied.mtbexporter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "PID",
    "TXTTHERAPIE",
    "TXTEVIDENZLEVEL",
    "TXTWIRKSTOFF",
    "GZPMID",
    "GZPRIORISIERUNG",
    "TXTSTUETZENDE_MOLEKULARE_ALTER"
})
public class BefTherapieoptionen {
    
    @JsonProperty("PID")
    private String pid;
    @JsonProperty("TXTTHERAPIE")
    private String therapie = "";
    @JsonProperty("TXTEVIDENZLEVEL")
    private String evidenzLevel;
    @JsonProperty("TXTWIRKSTOFF")
    private String wirkstoff;
    @JsonProperty("GZPMID")
    private String pubmedIds;
    @JsonProperty("GZPRIORISIERUNG")
    private Integer prioritaet;
    @JsonProperty("TXTSTUETZENDE_MOLEKULARE_ALTER")
    private String stuetzendeMolekulareAlteration;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTherapie() {
        return therapie;
    }

    public void setTherapie(String therapie) {
        this.therapie = therapie;
    }

    public String getWirkstoff() {
        return wirkstoff;
    }

    public void setWirkstoff(String wirkstoff) {
        this.wirkstoff = wirkstoff;
    }

    public String getEvidenzLevel() {
        return evidenzLevel;
    }

    public void setEvidenzLevel(String evidenzLevel) {
        this.evidenzLevel = evidenzLevel;
    }

    public String getPubmedIds() {
        return pubmedIds;
    }

    public void setPubmedIds(String pubmedIds) {
        this.pubmedIds = pubmedIds;
    }

    public Integer getPrioritaet() {
        return prioritaet;
    }

    public void setPrioritaet(Integer prioritaet) {
        this.prioritaet = prioritaet;
    }

    public String getStuetzendeMolekulareAlteration() {
        return stuetzendeMolekulareAlteration;
    }

    public void setStuetzendeMolekulareAlteration(String stuetzendeMolekulareAlteration) {
        this.stuetzendeMolekulareAlteration = stuetzendeMolekulareAlteration;
    }

}
