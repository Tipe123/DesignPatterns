public class BankAccount {

    private int acctnum;
    private int balance;
    private boolean isForeign = false;

    private double rate = 0.01;

    public BankAccount(int acctnum){
        this.acctnum = acctnum;
    }

    public int getAcctnum() {
        return acctnum;
    }

    public int getBalance() {
        return (int) balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isForeign() {
        return isForeign;
    }

    public void setForeign(boolean foreign) {
        isForeign = foreign;
    }

    public void deposit(int amt) {
        balance += amt;
    }

    public boolean hasEnoughCollateral(int loanamt) {
        return balance >= loanamt/2;
    }

    @Override
    public String toString(){
        return "Bank account" + acctnum + ": balance=" + balance+ ", is" + (isForeign ? "foreign" : "domestic");
    }

    public void addInterest() {

        balance += (int) (balance*rate);

    }
}
