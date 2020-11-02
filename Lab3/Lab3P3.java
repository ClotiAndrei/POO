public class Main {

    public static void main(String[] args) {
        String prop="nu stiu";
        int vocale=0 ,consoane=0;
        for(int i = 0 ;i<prop.length();i++){
            char c=prop.charAt(i);
            if( c=='a'|| c=='e' || c=='i' || c=='o' || c=='u')
                vocale++;
            else if(c>='a' && c<='z')
                consoane++;
        }
        System.out.println("Vocale: " + vocale );
        System.out.println("Consoane :" + consoane);

    }


}
