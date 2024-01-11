public class CheckingAccount implements BankAccount{

    //The rate variable is omitted

    private final int acctnum;
    protected int balance = 0;
    private boolean isForeign = false;
    public CheckingAccount(int acctnum){
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
        return this.balance >= 2*loanamt/3;
    }

    public String toString(){
        return "Checking Account "+acctnum +" : balance = " + balance  +
                " ,is " + ((isForeign) ? "Foreign":"Domestic");
    }

    @Override
    public void addInterest() {
        //Do nothing
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

    @Override
    public boolean equals(Object obj){
        if(!( obj instanceof CheckingAccount))
            return false;
        return this.getAcctNum() == ((CheckingAccount) obj).getAcctNum() ;
    }
}
