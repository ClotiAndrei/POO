public class Produs {
    private String nume;
    private int pret;
    private int numar_exemplare;

    public Produs(String nume, int pret, int numar_exemplare) {
        this.nume = nume;
        this.pret = pret;
        this.numar_exemplare = numar_exemplare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getNumar_exemplare() {
        return numar_exemplare;
    }

    public void setNumar_exemplare(int numar_exemplare) {
        this.numar_exemplare = numar_exemplare;
    }

    public boolean existenta_stoc(){
        if (this.numar_exemplare>0)
            return true;
        else
            return false;
    }
}
