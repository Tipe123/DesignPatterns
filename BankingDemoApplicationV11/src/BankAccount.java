public interface BankAccount extends Comparable<BankAccount>{

    public abstract int getAcctNum();
    public abstract int getBalance();
    public abstract boolean isForeign();
    public abstract void setForeign(boolean isForeign);
    public abstract void deposit(int amt);
    public abstract boolean hasEnoughCollateral(int loanamt);
    public abstract String toString();
    public abstract int fee();
    //Transparency rule
    void addInterest();

    //Adding code to an Interface

//    static BankAccount createSavingsWithDeposit(int acctnum , int amount){
//        BankAccount bankAccount = new SavingsAccount(acctnum);
//        bankAccount.deposit(amount);
//        return bankAccount;
//    }
//
//    default boolean isEmpty(){
//        return getBalance() == 0;
//    }

}
