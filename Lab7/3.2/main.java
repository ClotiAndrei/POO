public class main {
    public static void main(String[] args) {
        Complex a= new Complex(1,2);
        Complex b= new Complex(2,3);
        System.out.println(a.adunare(b));
        System.out.println(a.scadere(b));
        System.out.println(a.inmultire(b));
        System.out.println("Corect");
        Fractie c= new Fractie(1,3);
        Fractie d=new Fractie(1,3);
        System.out.println(c.adunare(d));
    }
}
