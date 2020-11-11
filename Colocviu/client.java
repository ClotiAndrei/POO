import java.util.ArrayList;

public class client extends Persoana {
    private int NrProdCumparate;
    public ArrayList<Produs> lista =new ArrayList<Produs>();

    public client(int nrProdCumparate) {
        NrProdCumparate = nrProdCumparate;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void InsertProdus(Produs a){
        lista.add(a);
    }

    public int getNrProdCumparate() {
        return NrProdCumparate;
    }

    public void setNrProdCumparate(int nrProdCumparate) {
        NrProdCumparate = nrProdCumparate;
    }

}
