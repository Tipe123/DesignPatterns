public abstract class CheckingAccount extends AbstractBankAccount{

    protected CheckingAccount(int acctnum) {
        super(acctnum);
    }

    @Override
    protected double collateralRatio() {
        return 3.0/4.0;
    }

    protected abstract double interestRate();

    protected abstract String accountType();

}
