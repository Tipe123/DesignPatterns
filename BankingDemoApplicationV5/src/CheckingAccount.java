public class CheckingAccount implements BankAccount{

    //The rate variable is ommited

    private int acctnum;
    private int balance = 0;
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
}
