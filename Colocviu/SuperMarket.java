import java.util.ArrayList;
import java.util.Collections;

public class SuperMarket {
    private ArrayList<Angajat> listaAngajati = new ArrayList<Angajat>();
    private ArrayList<ClientFidel> listaClientiFideli = new ArrayList<ClientFidel>();
    private ArrayList<Produs> listaProduse = new ArrayList<Produs>();

    public SuperMarket(ArrayList<Angajat> listaAngajati, ArrayList<ClientFidel> listaClientiFideli, ArrayList<Produs> listaProduse) {
        this.listaAngajati = listaAngajati;
        this.listaClientiFideli = listaClientiFideli;
        this.listaProduse = listaProduse;
    }

    public void AdaugaProduse(Produs p) {
        listaProduse.add(p);
    }

    public void AdaugaClientiFideli(ClientFidel c) {
        listaClientiFideli.add(c);
    }

    public void AdaugaAngajat(Angajat a) {
        listaAngajati.add(a);
    }

    public void listareClientiFideli() {
        for (int i = 0; i < listaClientiFideli.size() - 1; i++) {
            for (int j = i + 1; j < listaClientiFideli.size(); j++) {
                if (listaClientiFideli.get(i).getNrPuncteAcumulate() < listaClientiFideli.get(j).getNrPuncteAcumulate())
                    Collections.swap(listaClientiFideli, i, j);
            }
        }
        for (int i = 0; i < listaClientiFideli.size(); i++) {
            System.out.println(listaClientiFideli.get(i).toString());
        }
    }

    public void listareAngajati() {
        for (int i = 0; i < listaAngajati.size() - 1; i++) {
            for (int j = i + 1; j < listaAngajati.size(); j++) {
                if (listaAngajati.get(i).listaClientiServiti.size() < listaAngajati.get(j).listaClientiServiti.size()) {
                    Collections.swap(listaAngajati, i, j);
                }
            }
        }
        for(int i=0;i<listaAngajati.size();i++){
            System.out.println(listaAngajati.get(i).toString());
        }
    }

    public void Statistici(){
        int NrProdClient=0;
        int NrProdClientFidel=0;
        for(int i=0;i<listaAngajati.size();i++){
            for(int j=0;j<listaAngajati.get(i).getListaClientiServiti().size();j++){
                if(listaAngajati.get(i).listaClientiServiti.get(j) instanceof client){
                    NrProdClient+=listaAngajati.get(i).listaClientiServiti.get(j).getNrProdCumparate();
                }
                else
                    NrProdClientFidel+=listaAngajati.get(i).listaClientiServiti.get(j).getNrProdCumparate();
            }
        }
        System.out.println("Nr. produse cumparate de clienti: " + NrProdClient);
        System.out.println("Nr. produse cumparate de clienti fideli : " + NrProdClientFidel);
    }

    public ArrayList<Angajat> getListaAngajati() {
        return listaAngajati;
    }

    public void setListaAngajati(ArrayList<Angajat> listaAngajati) {
        this.listaAngajati = listaAngajati;
    }

    public ArrayList<ClientFidel> getListaClientiFideli() {
        return listaClientiFideli;
    }

    public void setListaClientiFideli(ArrayList<ClientFidel> listaClientiFideli) {
        this.listaClientiFideli = listaClientiFideli;
    }

    public ArrayList<Produs> getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(ArrayList<Produs> listaProduse) {
        this.listaProduse = listaProduse;
    }
}
