public class TestGhiozdan {

    public static void main(String[] args) {
       Ghiozdan g =new Ghiozdan();
       Caiet c1 =new Caiet();
       Caiet c2 =new Caiet();
       Caiet c3 =new Caiet();
       Caiet c4 =new Caiet();
       c1.setEticheta("PINTEXIM ");
       c2.setEticheta("COMATCHIM ");
       c3.setEticheta("PINTEXIM ");
       c4.setEticheta("COMATCHIM ");
       c1.getNume();
       c2.getNume();
       c3.getNume();
       c4.getNume();
        Manual m1 =new Manual();
        Manual m2 =new Manual();
        Manual m3 =new Manual();
        Manual m4 =new Manual();
        m1.setEticheta("CORINT ");
        m2.setEticheta("CORINT ");
        m3.setEticheta("ADEVARUL ");
        m4.setEticheta("ADEVARUL ");
        m1.getNume();
        m2.getNume();
        m3.getNume();
        m4.getNume();
        g.addC(c1);
        g.addC(c2);
        g.addC(c3);
        g.addC(c4);
        g.addM(m1);
        g.addM(m2);
        g.addM(m3);
        g.addM(m4);
        g.getNrRechizite();
        g.getNrCaiete();
        g.getNrManuale();
        g.listItems();
        g.listCaiet();
        g.listManual();

    }
}
