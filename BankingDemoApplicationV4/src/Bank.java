import java.util.Date;
import java.util.HashMap;

public class Bank {

    private HashMap<Integer,BankAccount> accounts ;

    private double rate = 0.01;
    private int nextact = 0;

    public Bank(HashMap<Integer, BankAccount> accounts, int nextact) {
        this.accounts = accounts;
        this.nextact = nextact;
    }

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

        if(bankAccount.isForeign())
            System.out.println(acctnum +"\n"+amt+"\n"+new Date());
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
