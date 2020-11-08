public class CurrentAccount extends Account {
    private boolean overdraft;

    public CurrentAccount(int number) {
        super(number);
    }

    public boolean getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(boolean overdraft) {
        this.overdraft = overdraft;
    }
}
