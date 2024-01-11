public abstract class CheckingAccount extends AbstractBankAccount{

    protected CheckingAccount(int acctnum) {
        super(acctnum);
    }

    @Override
    public boolean hasEnoughCollateral(int loanamt) {
        return balance >= 2*loanamt/3;
    }

    public abstract String toString();
    public abstract void addInterest();
}
