public class SavingAccount extends Account {
    private double interest=0.02;

    public SavingAccount(int number) {
        super(number);
    }

    public void addInterest(int month){
        double x=this.getBalance()*(1+month*interest);
        x=this.getBalance()-x;
        deposit(x);
    }
}
