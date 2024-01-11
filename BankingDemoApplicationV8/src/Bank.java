import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<Integer,BankAccount> accounts;
    private int nextacct;

    public Bank(Map<Integer,BankAccount> accounts, int nextacct){
        this.accounts = accounts;
        this.nextacct = nextacct;
    }

    public int newAccount(int type, boolean isForeign){

        int acctnum = this.nextacct++;
        BankAccount bankAccount;

        if(type == 1 )
            bankAccount = new SavingsAccount(acctnum);
        else if(type == 2)
            bankAccount = new RegularChecking(acctnum);
        else
            bankAccount = new InterestChecking(acctnum);

        bankAccount.setForeign(isForeign);
        this.accounts.put(acctnum,bankAccount);

        return acctnum;
    }

    /**
     * Since the variable bankAccount is interface-typed, the method does not know
        whether the account it gets from the map is a savings account or checking account.
     *
     * But it doesn't need to know, the method simply calls bankAccount.getBalance(),
        which will execute the code of whichever the object bankAccount refers to.
     *
     *
     * The statement accounts.get(acctnum) will get the object at which the bankAccount variable will reference
     *
     * */
    public int getBalance(int acctnum){

        BankAccount bankAccount = accounts.get(acctnum);
        return bankAccount.getBalance();
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

    /**
         Due to the rule of Transparency that states, A client should be able to use an interface
         without needing to know the classes that implement that interface
     * */
    public void addInterest(){
        for(BankAccount bankAccount: accounts.values())
            bankAccount.addInterest();
    }


}
