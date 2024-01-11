public class RegularChecking extends CheckingAccount{

    protected RegularChecking(int acctnum) {
        super(acctnum);
    }

    @Override
    public String toString() {
        return "Regular Checking Account "+acctnum +" : balance = " + balance  +
                " ,is " + ((isforeign) ? "Foreign":"Domestic");
    }

    @Override
    public void addInterest() {

    }
}
