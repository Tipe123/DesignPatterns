public class SavingsAccount extends AbstractBankAccount{

    protected SavingsAccount(int acctnum) {
        super(acctnum);
    }

    @Override
    public boolean hasEnoughCollateral(int loanamt) {
        return balance >= loanamt/2;
    }

    @Override
    public void addInterest() {
        double rate = 0.01;
        this.balance +=(int) (balance*rate);
    }

    @Override
    public String toString() {
        return "Savings Account "+acctnum +" : balance = " + balance  +
                " ,is " + ((isforeign) ? "Foreign":"Domestic");
    }
}
