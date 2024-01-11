public class InterestChecking extends CheckingAccount{
    private double rate = 0.01;

    protected InterestChecking(int acctnum) {
        super(acctnum);
    }

    @Override
    public String toString() {
        return "Interest Checking Account "+acctnum +" : balance = " + balance  +
                " ,is " + ((isforeign) ? "Foreign":"Domestic");
    }

    @Override
    public void addInterest() {
        this.balance+=(int) this.balance * this.rate;
    }
}
