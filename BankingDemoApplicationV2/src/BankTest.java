public class BankTest {

    private static Bank bank = new Bank();
    private static int acct = bank.newAccount();

    public static void main(String[] args){
        verifyBalance("Initial amount", 0);
        bank.deposit(acct,10);
        verifyBalance("Initial amount", 10);
    }

    private static void verifyBalance(String msg,int expectedVal){
        int bal = bank.getBalance(acct);
        boolean ok = (bal == expectedVal);
        String result = ok ? "Good" : "Bad";
        System.out.println(msg + " : " + result);
    }

    private static void verifyLoan(String msg, int loanAmt , boolean expectedVal){
        boolean answer = bank.authorizeloan(acct,loanAmt);
        boolean ok = (answer == expectedVal);
        String result = ok? "Good" : "Bad";
        System.out.println(msg + " : " + result);
    }
}
