public abstract class AbstractBankAccount implements BankAccount{

    protected int acctnum;
    protected int balance = 0;
    private OwnerStrategy owner = new Domestic();

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
        return this.owner.isForeign();
    }

    @Override
    public void setForeign(boolean isForeign) {
        this.owner = isForeign ? new Foreign() : new Domestic();
    }
    @Override
    public int fee(){
        return owner.fee();
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
    public boolean hasEnoughCollateral(int loanamt){
        double ratio = collateralRatio();
        return balance >= loanamt * ratio;
    }


    @Override
    public void addInterest(){
        balance += (int) (balance*interestRate());
    }

    @Override
    public  String toString(){
        return accountType() + " account" + acctnum +" :balance = " + balance
                + ", is " +owner.toString() +", fee = " + fee();
    }

    //The following are abstract helper methods that the subclass can implement
    protected abstract double collateralRatio();

    protected abstract double interestRate();

    protected abstract String accountType();

}
