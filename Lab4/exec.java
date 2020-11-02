import java.awt.*;

public class exec {

    public static void main(String[] args) {
        Autovehicul dacia= new Autovehicul();
        Sofer sofer1=new Sofer("Clotan","Andrei",19,"222333");
        Proprietar proprietar1= new Proprietar("Piperea","Paul",17,2008);
        Autovehicul yzf= new Autovehicul("Yamaha",Color.BLUE,0,133,0,sofer1,proprietar1);
        System.out.println(yzf.getMarca());
        System.out.println(yzf.getCuloare());
        System.out.println(yzf.getViteza());
        System.out.println((yzf.getViteza_max()));
        System.out.println(yzf.getTreapta());
        //yzf.deplasare(200);
    }
}
