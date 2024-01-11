public class CheckingAccount extends AbstractBankAccount{


    protected CheckingAccount(int acctnum) {
        super(acctnum);
    }

    @Override
    public boolean hasEnoughCollateral(int loanamt) {
        return balance >= 2*loanamt/3;
    }

    @Override
    public void addInterest() { }

    @Override
    public String toString() {
        return "Checking Account "+acctnum +" : balance = " + balance  +
                " ,is " + ((isforeign) ? "Foreign":"Domestic");
    }
}
