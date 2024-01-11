import java.util.HashMap;

public class Bank {

    private HashMap<Integer,BankAccount> accounts = new HashMap<>();

    private double rate = 0.01;
    private int nextact = 0;

    public int getBalance(int acctnum){
        BankAccount bankAccount = accounts.get(acctnum);
        return bankAccount.getBalance();
    }

    public int newAccount(boolean isforeign){
        int acctnum = nextact++;
        BankAccount bankAccount = new BankAccount(acctnum);
        bankAccount.setForeign(isforeign);
        accounts.put(acctnum,bankAccount);
        return acctnum;
    }

    public void deposit(int acctnum,int amt){
        BankAccount bankAccount = accounts.get(acctnum);
        bankAccount.deposit(amt);
    }

    public void setForeign(int acctnum,boolean isforeign){
        BankAccount bankAccount = accounts.get(acctnum);
        bankAccount.setForeign(isforeign);
    }

    public boolean authorizedLoan(int acctnum,int loanamt){
        BankAccount bankAccount = accounts.get(acctnum);

        return bankAccount.hasEnoughCollateral(loanamt);
    }

    @Override
    public String toString() {
        String result = "The bank has "+ accounts.size() + " accounts.";
        for(BankAccount bankAccount : accounts.values()){
            result += "\n\t" + bankAccount.toString();
        }

        return result;
    }

    public void addInterest(){
        for(BankAccount bankAccount:accounts.values()){
            bankAccount.addInterest();
        }
    }
}
