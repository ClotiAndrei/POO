import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.sql.SQLOutput;

public class main {
    public static void main(String[] args) {
        BigInteger numarBoabe =BigInteger.valueOf(0);
        BigInteger numarCasaCurenta=BigInteger.valueOf(1);

        for(int i=1 ;i<=65;i++)
        {
                numarBoabe=numarBoabe.add(numarCasaCurenta);
                numarCasaCurenta=numarCasaCurenta.multiply(BigInteger.valueOf(2));

        }
        System.out.println(numarBoabe);
    }
}
