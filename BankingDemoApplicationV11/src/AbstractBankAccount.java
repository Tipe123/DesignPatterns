public  class AbstractBankAccount implements BankAccount{

    private int acctnum;
    private int balance = 0;
    private OwnerStrategy owner = new Domestic();
    private TypeStrategy ts;

    public AbstractBankAccount(int acctnum,TypeStrategy ts){
        this.acctnum = acctnum;
        this.ts = ts;
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
    private  double collateralRatio(){
        return ts.collateralRatio();
    };

    private double interestRate(){
        return ts.interestRate();
    };

    private String accountType(){
        return ts.accountType();
    };

}
