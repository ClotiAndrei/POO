public class Main {

    public static void main(String[] args) {
	 int a=49;
	 int b=6;
	 double sanse=1;
	 for(int i=1;i<=b;++i){
	     sanse=sanse*(a-i+1)/i;
     }
        System.out.println("Sanse: "+ sanse);
    }
}
