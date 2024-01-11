public class BankAccount {

    private int acctnum;
    private int balance;
    private boolean isForeign = false;

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
}
