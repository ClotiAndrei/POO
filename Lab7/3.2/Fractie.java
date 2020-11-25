public class Fractie implements Numeric <Fractie> {
    public int numarator;
    public int numitor;

    public Fractie(int numarator, int  numitor){
        this.numitor = numitor;
        this.numarator = numarator;
    }

    @Override
    public Fractie adunare(Fractie a) {
        Fractie c=new Fractie(this.numarator,this.numitor);
        c.numarator=c.numitor*a.numarator + c.numarator*a.numitor;
        c.numitor=c.numitor*a.numitor;
        c.reduceFraction();
        return c;
    }
      public Fractie reduceFraction()
    {
        int d;
        d = __gcd(this.numarator, this.numitor);

        this.numarator = this.numarator / d;
        this.numitor = this.numitor / d;
        return this;
    }

    static int __gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return __gcd(b, a % b);

    }

    @Override
    public Fractie scadere(Fractie a) {
        return null;
    }

    @Override
    public Fractie inmultire(Fractie a) {
        return null;
    }

    @Override
    public String toString() {
        return "Fractie{" +
                "numarator=" + numarator +
                ", numitor=" + numitor +
                '}';
    }
}

