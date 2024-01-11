public class SavingsAccount implements BankAccount{

    private final int acctnum;
    private int balance;
    private boolean isForeign = false;

    private final double rate = 0.01;

    public SavingsAccount(int acctnum){
        this.acctnum = acctnum;
    }

    @Override
    public int getAcctNum() {
        return this.acctnum;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public boolean isForeign() {
        return this.isForeign;
    }

    @Override
    public void setForeign(boolean isForeign) {
        this.isForeign = isForeign;
    }

    @Override
    public void deposit(int amt) {
        this.balance += amt;
    }

    @Override
    public boolean hasEnoughCollateral(int loanamt) {
        return balance >= loanamt/2;
    }

    public String toString(){
        return "Savings Account "+acctnum +" : balance = " + balance  +
                " ,is " + ((isForeign) ? "Foreign":"Domestic");
    }

    public void addInterest(){
        this.balance +=(int) (balance*rate);
    }

    @Override
    public int compareTo(BankAccount bankAccount) {

        int balance1 = getBalance();
        int balance2 = bankAccount.getBalance();
        if(balance1 == balance2)
            return getAcctNum() - bankAccount.getAcctNum();
        else
            return balance1 - balance2;
    }

    /**
     * The equals method from class Object compares the instances of object based on their memory location
     *
     * This updated version of it will compare the instance of objects based on their account number
     *
     * */
    @Override
    public boolean equals(Object obj){
        if(! (obj instanceof SavingsAccount))
            return false;
        return this.getAcctNum() == ((SavingsAccount) obj).getAcctNum();
    }
}
