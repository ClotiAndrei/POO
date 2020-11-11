import java.util.ArrayList;

public class Angajat extends Persoana {
    private String DataAngajare;
    private int NrClientiServiti;
    public ArrayList<client> listaClientiServiti = new ArrayList<client>();


    public Angajat(String dataAngajare, int nrClientiServiti) {
        DataAngajare = dataAngajare;
        NrClientiServiti = nrClientiServiti;
    }

    public long Servire(client c) {
        long suma = 0;
        for (int i = 0; i < c.lista.size(); i++) {
            suma += c.lista.get(i).getPret();
        }
        if(listaClientiServiti.contains(c)==false)
            listaClientiServiti.add(c);
    return suma;
    }

    public long Servire(ClientFidel c) {
        long suma = 0;
        for (int i = 0; i < c.lista.size(); i++) {
            suma += c.lista.get(i).getPret();
        }
        if(listaClientiServiti.contains(c)==false)
            listaClientiServiti.add(c);
    return suma;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getDataAngajare() {
        return DataAngajare;
    }

    public void setDataAngajare(String dataAngajare) {
        DataAngajare = dataAngajare;
    }

    public int getNrClientiServiti() {
        return NrClientiServiti;
    }

    public void setNrClientiServiti(int nrClientiServiti) {
        NrClientiServiti = nrClientiServiti;
    }

    public ArrayList<client> getListaClientiServiti() {
        return listaClientiServiti;
    }

    public void setListaClientiServiti(ArrayList<client> listaClientiServiti) {
        this.listaClientiServiti = listaClientiServiti;
    }
}
