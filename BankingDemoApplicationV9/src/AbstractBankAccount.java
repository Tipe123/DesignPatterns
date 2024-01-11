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
    public boolean hasEnoughCollateral(int loanamt){
        double ratio = collateralRatio();
        return balance >= loanamt * ratio;
    }


    @Override
    public void addInterest(){
        balance += (int) (balance*interestRate());
    }

    /**A Naive implementation of the fee method */

    /*
    * Although this code is straightforward it's use of the "if-statement" is bad design
    * The method will need to be modified each time the bank changes the fee categories
    *   - which is a blatant violation of the Open/Closed rule
    * */

    public int fee(){
        if(isforeign)
            return 500;
        else
            return 0;
    }

    @Override
    public  String toString(){
        return accountType() + " account" + acctnum +" :balance = " + balance
                + ", is " +(isforeign ? "foreign":"domestic") + ", fee = "+fee();
    }

    //The following are abstract helper methods that the subclass can implement
    protected abstract double collateralRatio();

    protected abstract double interestRate();

    protected abstract String accountType();




}
