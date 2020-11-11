import java.util.ArrayList;

public class ClientFidel extends client {
    private int NrPuncteAcumulate;
    private boolean discount;

    public ClientFidel(int nrProdCumparate, int nrPuncteAcumulate, boolean discount) {
        super(nrProdCumparate);
        NrPuncteAcumulate = nrPuncteAcumulate;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getNrPuncteAcumulate() {
        return NrPuncteAcumulate;
    }

    public void setNrPuncteAcumulate(int nrPuncteAcumulate) {
        NrPuncteAcumulate = nrPuncteAcumulate;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public void CalculPuncte(Angajat a){
        long x = a.Servire(this);
        this.NrPuncteAcumulate=(int)(x/100);
    }
}

