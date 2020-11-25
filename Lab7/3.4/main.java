
import java.util.Arrays;


public class main {
    public static void main(String[] args) {
        Persoana x[]=new Persoana[10];

        for(int i=0;i<10;i++)
            x[i]= new Persoana("Clotan" + i,"Andrei" + i,10-i);
        Arrays.sort(x);
        for(Persoana persoana :x)
            System.out.println(persoana);
    }
}
