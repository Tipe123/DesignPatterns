
/**
 * An abstract class cannot be instantiated directly.
 *Instead, it is necessary to instantiate one of its subclasses so that its abstract method will have some code
 * */

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
            // According to my understanding this is an error
            return getAcctNum() - bankAccount.getAcctNum();
        else
            return balance1 - balance2;
    }

    @Override
    public boolean equals(Object obj){
        if(! (obj instanceof  BankAccount))
            return false;
        BankAccount bankAccount = (BankAccount) obj;
        return getAcctNum() == bankAccount.getAcctNum();
    }

    /**

     * The declaration for the methods hasEnoughCollateral,addInterest, and toString are declared to be abstract


     * The issue is that AbstractBankAccount implements BankAccount "Interface" so the methods needs to be in its API
     *  - However, the class has no useful implementation of the methods because the code is provided by the subclasses.

     *  By declaring those methods to be abstract, the class asserts that its subclasses will provide code for them.
     *
     */

    @Override
    public abstract boolean hasEnoughCollateral(int loanamt);

    @Override
    public abstract void addInterest() ;

    @Override
    public abstract String toString();

}
