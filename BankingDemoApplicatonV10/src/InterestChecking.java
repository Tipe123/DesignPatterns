public class InterestChecking extends CheckingAccount{
    private double rate = 0.01;

    protected InterestChecking(int acctnum) {
        super(acctnum);
    }


    @Override
    protected double interestRate() {
        return 0.01;
    }

    @Override
    protected String accountType() {
        return "Interest checking";
    }


    @Override
    public void addInterest() {
        this.balance+=(int) this.balance * this.rate;
    }
}
