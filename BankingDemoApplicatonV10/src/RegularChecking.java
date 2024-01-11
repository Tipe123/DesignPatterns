public class RegularChecking extends CheckingAccount{

    protected RegularChecking(int acctnum) {
        super(acctnum);
    }


    @Override
    protected double interestRate() {
        return 0;
    }

    @Override
    protected String accountType() {
        return "Regular checking";
    }


    @Override
    public void addInterest() {

    }
}
