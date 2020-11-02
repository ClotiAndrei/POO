import java.awt.*;
import java.sql.SQLOutput;

public class Autovehicul {
    private String marca;
    private Color culoare;
    private int viteza;
    private int viteza_max;
    private int treapta;
    private Sofer sofer1;
    private Proprietar proprietar1;

public Autovehicul(String marca,Color culoare,int viteza,int viteza_max,int treapta,Sofer sofer1,Proprietar proprietar1){
    this.marca=marca;
    this.culoare=culoare;
    this.viteza=viteza;
    this.viteza_max=viteza_max;
    this.treapta=treapta;
    this.sofer1=sofer1;
    this.proprietar1=proprietar1;
}
public Autovehicul(){
    this.marca=null;
    this.culoare=null;
    this.viteza=0;
    this.viteza_max=0;
    this.treapta=0;
    this.sofer1=null;
    this.proprietar1=null;
}

    public Proprietar getProprietar1() {
        return proprietar1;
    }

    public void setProprietar1(Proprietar proprietar1) {
        this.proprietar1 = proprietar1;
    }

    public Sofer getSofer1() {
        return sofer1;
    }

    public void setSofer1(Sofer sofer1) {
        this.sofer1 = sofer1;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Color getCuloare() {
        return culoare;
    }

    public void setCuloare(Color culoare) {
        this.culoare = culoare;
    }

    public int getViteza() {
        return viteza;
    }

    public void setViteza(int viteza) {
        this.viteza = viteza;
    }

    public int getViteza_max() {
        return viteza_max;
    }

    public void setViteza_max(int viteza_max) {
        this.viteza_max = viteza_max;
    }

    public int getTreapta() {
        return treapta;
    }

    public void setTreapta(int treapta) {
        this.treapta = treapta;
    }

   void deplasare(int distanta){
       System.out.println("Pornire");
       accelerare(10);
       int dist_parc=0;
       int hr=0;
       while(dist_parc<distanta) {
           hr+=1;
           System.out.println(hr);
           accelerare(10);
           if (this.viteza < 30) {
               change(2);
               System.out.println("Autovehiculul are viteza" + this.getViteza() + " si este in treapta " + this.getTreapta());
            }
           else if (this.viteza >= 30 && this.viteza < 40) {
               change(3);
               System.out.println("Autovehiculul are viteza" + this.getViteza() + " si este in treapta " + this.getTreapta());
           }
           else if (this.viteza >= 40 && this.viteza < 50) {
               change(4);
               System.out.println("Autovehiculul are viteza" + this.getViteza() + " si este in treapta " + this.getTreapta());
           }
           else if (this.viteza >= 50) {
               change(5);
               System.out.println("Autovehiculul are viteza" + this.getViteza() + " si este in treapta " + this.getTreapta());
           }
           decelerare(10);
           dist_parc=dist_parc+this.viteza/hr;
       }
       oprire();
       System.out.println("Masina a oprit");
    }

    public int accelerare(int viteza){
    int c=this.viteza;
    c+=viteza;
    if(c>this.viteza_max)
        return viteza_max;
    else
        return c ;
    }

    public int decelerare(int viteza){
    return this.viteza-viteza;
    }

    public void change(int treapta){
        this.treapta=treapta;
    }

    public int oprire(){
    return -1;
    }

}
