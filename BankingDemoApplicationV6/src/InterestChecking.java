public class InterestChecking extends CheckingAccount{

    private final double rate = 0.01;


    public InterestChecking(int acctnum) {
        super(acctnum);
    }

    @Override
    public String toString(){
       return "Checking Account "+getAcctNum() +" : balance = " + this.balance  +
                " ,is " + ((isForeign()) ? "Foreign":"Domestic");

    }
    @Override
    public void addInterest(){
        //It is now possible to call the variable balance because we've used the protected
        //modifier to declare the variable balance

        this.balance += (int) (balance*rate);
    }
}
