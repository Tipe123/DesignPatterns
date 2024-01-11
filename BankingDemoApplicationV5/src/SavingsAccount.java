public class SavingsAccount implements BankAccount{

    private int acctnum;
    private int balance=0;
    private boolean isForeign = false;

    private double rate = 0.01;

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
        balance +=(int) (balance*rate);
    }
}
