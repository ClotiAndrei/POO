public class Proprietar {
    private String nume;
    private String prenume;
    private int varsta;
    private int an_achizitie;

    public Proprietar(String nume, String prenume, int varsta, int an_achizitie) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.an_achizitie = an_achizitie;
    }

    public Proprietar() {
        this.nume = null;
        this.prenume = null;
        this.varsta = 0;
        this.an_achizitie = 0;
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

    public int getAn_achizitie() {
        return an_achizitie;
    }

    public void setAn_achizitie(int an_achizitie) {
        this.an_achizitie = an_achizitie;
    }
}