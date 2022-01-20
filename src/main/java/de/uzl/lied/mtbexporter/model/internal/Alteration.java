package de.uzl.lied.mtbexporter.model.internal;

/**
 * Internal class to represent alterations.
 */
public class Alteration {
    private String gene;
    private String hgnc;
    private String pHgvs;
    private Double allelfrequenz;

    /**
     * @return the gene
     */
    public String getGene() {
        return gene;
    }

    /**
     * @param gene the gene to set
     */
    public void setGene(String gene) {
        this.gene = gene;
    }

    /**
     * @return the hgnc
     */
    public String getHgnc() {
        return hgnc;
    }

    /**
     * @param hgnc the hgnc to set
     */
    public void setHgnc(String hgnc) {
        this.hgnc = hgnc;
    }

    /**
     * @return the pHgvs
     */
    public String getpHgvs() {
        return pHgvs;
    }

    /**
     * @param pHgvs the pHgvs to set
     */
    public void setpHgvs(String pHgvs) {
        this.pHgvs = pHgvs;
    }

    /**
     * @return the allelfrequenz
     */
    public Double getAllelfrequenz() {
        return allelfrequenz;
    }

    /**
     * @param allelfrequenz the allelfrequenz to set
     */
    public void setAllelfrequenz(Double allelfrequenz) {
        this.allelfrequenz = allelfrequenz;
    }

    @Override
    public String toString() {
        String alteration = "";
        if (gene != null) {
            alteration += "Gen " + gene;
        }
        if (hgnc != null) {
            alteration += ", HGNC ID " + hgnc;
        }
        if (pHgvs != null) {
            alteration += ", " + pHgvs;
        }
        if (allelfrequenz != null) {
            alteration += ", Allelfrequenz " + String.format("%.2f", allelfrequenz) + "%";
        }

        return alteration;
    }
}
