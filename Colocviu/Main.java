public class Main {

    public static void main(String[] args) {
        Produs p=new Produs("Cafea",10,5);
        Produs q=new Produs("Apa",2,100);
        client c=new client(10);
        c.setNume("Andrei Clotan");
        c.setID(1);
        client c1=new client(20);
        c1.setNume("Tibrea Andrei");
        c1.setID(2);
        System.out.println(c.toString());
    }
}
