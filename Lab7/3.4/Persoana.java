public class Persoana implements Comparable<Persoana> {
    public String nume;
    public String prenume;
    public int varsta;

    public Persoana(String nume, String prenume, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                '}';
    }

    @Override
    public int compareTo(Persoana o) {
        if (this.varsta > o.varsta)
            return 1;
        else
            return -1;
    }
}
