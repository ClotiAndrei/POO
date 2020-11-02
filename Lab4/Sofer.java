public class Sofer {
    private String nume;
    private String prenume;
    private int varsta;
    private String nr_permis;

    public Sofer(String nume, String prenume, int varsta, String nr_permis) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.nr_permis = nr_permis;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getNr_permis() {
        return nr_permis;
    }

    public void setNr_permis(String nr_permis) {
        this.nr_permis = nr_permis;
    }
}