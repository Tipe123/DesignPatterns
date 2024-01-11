public abstract class AbstractBankAccount implements BankAccount{

    protected int acctnum;
    protected int balance = 0;
    protected boolean isforeign = false;

    protected AbstractBankAccount(int acctnum){
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
        return this.isforeign;
    }

    @Override
    public void setForeign(boolean isForeign) {
        this.isforeign = isForeign;
    }

    @Override
    public void deposit(int amt) {
        this.balance += amt;
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
    public abstract boolean hasEnoughCollateral(int loanamt);

    @Override
    public abstract void addInterest() ;

    @Override
    public abstract String toString();

}
