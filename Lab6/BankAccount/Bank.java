public class Bank {
    private Account[] a;

    public void update() {
        for (int i = 0; i < a.length; i++) {
            if (a[i].getAccountNumber() > 0) {
                if (a[i] instanceof SavingAccount)
                    ((SavingAccount) a[i]).addInterest(1);
                else if (a[i] instanceof CurrentAccount) {
                    if (((CurrentAccount) a[i]).getOverdraft() == true)
                        System.out.println("Account " + a[i].getAccountNumber() + "is in overdraft");
                }

            }

        }
    }

    public void openAccount(int sum){
        int x=a.length;
        x++;
        a[x]=new Account(x);
        a[x].deposit(sum);
    }

    public void closeAccount(int number){
    a[number]= new Account(-1);
    }

    public void payDivident(int number,int sum){
        a[number].deposit(sum);
    }
}

