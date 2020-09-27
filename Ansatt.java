public class Ansatt {
    private String fornavn;
    private String etternavn;
    private String stilling;
    private Kjonn kjonn;
    private int lonn;

    @Override
    public String toString() {
        String tempString = "";
        tempString += fornavn + " " + etternavn + "\n";
        tempString += stilling + "\n";
        tempString += "Kjønn: " + kjonn + "\n";
        tempString += "Årslønn: " + lonn + "\n";

        return tempString;
    }

    public Ansatt(String fornavn, String etternavn, String stilling, Kjonn kjonn, int lonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.stilling = stilling;
        this.kjonn = kjonn;
        this.lonn = lonn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public Kjonn getKjonn() {
        return kjonn;
    }

    public void setKjonn(Kjonn kjonn) {
        this.kjonn = kjonn;
    }

    public int getLonn() {
        return lonn;
    }

    public void setLonn(int lonn) {
        this.lonn = lonn;
    }
}