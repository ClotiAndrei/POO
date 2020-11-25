public class Complex implements Numeric<Complex> {
  public double real;
  public double imaginar;

    public Complex(double real, double imaginar) {
        this.real = real;
        this.imaginar = imaginar;
    }

    @Override
    public Complex scadere(Complex a) {
        Complex c=new Complex(this.real,this.imaginar);
        c.real-=a.real;
        c.imaginar-=a.imaginar;
        return c;
    }

    @Override
    public Complex inmultire(Complex a) {
        Complex c=new Complex(this.real,this.imaginar);
        c.real*=a.real;
        c.imaginar*=a.imaginar;
        return c;
    }

    @Override
    public Complex adunare(Complex a) {
        Complex c=new Complex(this.real,this.imaginar);
        c.real+=a.real;
        c.imaginar+=a.imaginar;
        return c;

    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", imaginar=" + imaginar +
                '}';
    }
}
