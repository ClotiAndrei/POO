import java.util.ArrayList;

public class Ghiozdan {
    private ArrayList<Rechizita> lista = new ArrayList<Rechizita>();


    public void addC(Caiet a){
        lista.add(a);
    }

    public void addM(Manual a){
        lista.add(a);
    }

    public void listItems(){
        System.out.println("Lista: ");
        for(int i=0; i< lista.size();i++){
            System.out.println(lista.get(i).getEticheta());
        }
    }

    public void listManual(){
        System.out.println("Manualele din lista: ");
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getEticheta().charAt(0)=='M')
                System.out.println(lista.get(i).getEticheta());
        }
    }

    public void listCaiet(){
        System.out.println("Caietele din lista: ");
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getEticheta().charAt(0)=='C')
                System.out.println(lista.get(i).getEticheta());
        }
    }

    public void getNrRechizite(){
        System.out.println("Nr rechizite: " + lista.size());
    }

    public void getNrCaiete() {
        int x = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getEticheta().charAt(0) == 'C') {
                x++;
            }
        }
        System.out.println("Nr caiete :" + x);

    }

    public void getNrManuale() {
        int x = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getEticheta().charAt(0) == 'M') {
                x++;
            }
        }
        System.out.println("Nr manuale :" + x);

    }

}
