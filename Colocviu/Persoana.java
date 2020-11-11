public abstract class  Persoana {
    private int ID;
    private String nume;


    public String toString(){
        return "ID-ul persoanei este " + this.ID +
                " , iar numele este " + this.nume;


    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
