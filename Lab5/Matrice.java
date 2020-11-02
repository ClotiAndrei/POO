public class Matrice{
    private int l;
    private int c;
    private Complex[][] matrix;

    public Matrice(int l, int c) {
        this.l = l;
        this.c = c;
        matrix=new Complex[l][c];
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public Complex[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Complex[][] matrix) {
        this.matrix = matrix;
    }

    public Matrice add(Matrice b){
        Matrice a=this;
        Matrice C=new Matrice(l,c);
        for(int i=0;i<l;i++){
            for(int j=0;j<c;j++)
                C.matrix[i][j]=a.matrix[i][j].add(b.matrix[i][j]);
        }
    return C;
    }

    public Matrice sub(Matrice b){
        Matrice a=this;
        Matrice C=new Matrice(l,c);
        for(int i=0;i<l;i++){
            for(int j=0;j<c;j++)
                C.matrix[i][j]=a.matrix[i][j].sub(b.matrix[i][j]);
        }
        return C;
    }

    public Matrice inmul(Matrice b){
        Matrice a=this;
        Matrice C=new Matrice(l,c);
        for(int i=0;i<l;i++){
            for(int j=0;j<c;j++)
                C.matrix[i][j]=a.matrix[i][j].inmul(b.matrix[i][j]);
        }
        return C;
    }

    public Matrice inmuls(int s){
        Matrice a=this;
        Matrice C=new Matrice(l,c);
        for(int i=0;i<l;i++){
            for(int j=0;j<c;j++)
                C.matrix[i][j]=a.matrix[i][j].immulscalar(s);
        }
        return C;
    }

}
