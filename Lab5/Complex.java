public class Complex {
    private double real;
    private double img;


    public Complex(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public Complex(){
        this.real=0;
        this.img=0;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImg() {
        return img;
    }

    public void setImg(double img) {
        this.img = img;
    }

    public Complex add(Complex b){
    Complex a=this;
    double re=a.real+b.real;
    double imag=a.img+b.img;
    return new Complex(re,imag);
    }

    public Complex sub(Complex b){
        Complex a=this;
        double re=a.real-b.real;
        double imag=a.img-b.img;
        return new Complex(re,imag);
    }

    public Complex inmul(Complex b){
        Complex a=this;
        double re=a.real*b.real;
        double imag=a.img*b.img;
        return new Complex(re,imag);
    }

    public Complex immulscalar(int a){
        double re=this.real*a;
        double imag=this.img*a;
        return new Complex(re,imag);
    }

}
