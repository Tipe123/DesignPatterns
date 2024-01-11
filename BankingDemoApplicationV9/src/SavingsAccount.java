public class SavingsAccount extends AbstractBankAccount{

    protected SavingsAccount(int acctnum) {
        super(acctnum);
    }


    @Override
    protected double collateralRatio() {
        return 1.0/2.0;
    }

    @Override
    protected double interestRate() {
        return 0.01;
    }

    @Override
    protected String accountType() {
        return "Savings";
    }
}
