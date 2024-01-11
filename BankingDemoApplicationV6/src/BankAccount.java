public interface BankAccount extends Comparable<BankAccount>{
     int getAcctNum();
     int getBalance();
     boolean isForeign();
     void setForeign(boolean isForeign);
     void deposit(int amt);
     boolean hasEnoughCollateral(int loanamt);
     String toString();

    //Transparency rule
    void addInterest();

    //Adding code to an Interface

    static BankAccount createSavingsWithDeposit(int acctnum , int amount){
        BankAccount bankAccount = new SavingsAccount(acctnum);
        bankAccount.deposit(amount);
        return bankAccount;
    }

    default boolean isEmpty(){
        return getBalance() == 0;
    }
}
