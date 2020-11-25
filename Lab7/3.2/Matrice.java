
public class Matrice {
    public int l;
    public int c;
    public Numeric[][] matrix;

    public Matrice(int l, int c, Numeric[][] matrix) {
        this.l = l;
        this.c = c;
        this.matrix = matrix;
    }

    public Matrice add(Matrice a) {
        Matrice c=new Matrice(this.l,this.c,this.matrix);
        for(int i=0;i<l;i++)
            for(int j=0;j<l;j++){
                c.matrix[i][j]=c.matrix[i][j].adunare(a.matrix[i][j]);
        }
        return 0;
    }

    @Override
    public Matrice scadere(Matrice a) {
        Matrice c=new Matrice(this.l,this.c,this.matrix);
        for(int i=0;i<l;i++)
            for(int j=0;j<l;j++){
                c.matrix[i][j]=c.matrix[i][j].scadere(a.matrix[i][j]);
            }
        return 0;
    }

    @Override
    public Matrice inmultire(Matrice a) {
        Matrice c=new Matrice(this.l,this.c,this.matrix);
        for(int i=0;i<l;i++)
            for(int j=0;j<l;j++){
                c.matrix[i][j]=c.matrix[i][j].inmultire(a.matrix[i][j]);
            }
        return 0;
}



