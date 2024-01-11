import java.util.Scanner;

public class BankClient {

    private int current = -1;
    private final Scanner scanner ;
    private boolean done = false;

    private final Bank bank ;

    //Constructor injection
    public BankClient(Scanner scanner, Bank bank) {
        this.scanner = scanner;
        this.bank = bank;
    }

    public void run() {

        while(!done){
            System.out.println("""
                    Enter commands :\s
                     0 = quit
                     1 = new
                     2 = select
                     3 = deposit
                     4 = loan
                     5 = show
                     6 = interest
                     7 = set foreign""");
            int command = scanner.nextInt();
            processCommand(command);
        }

    }

    private void processCommand(int command){
        switch (command) {
            case 0 -> quit();
            case 1 -> createNewAccount();
            case 2 -> selectAccount();
            case 3 -> deposit();
            case 4 -> loan();
            case 5 -> showAll();
            case 6 -> interest();
            case 7 -> setForeign();
            default -> System.out.println("Invalid command");
        }
    }

    private void quit(){
        done = true;
    }

    private void createNewAccount(){
        boolean isforeign = requestForeign();
        int type;


        System.out.println("""
                    Enter :\s
                     1 = Savings account
                     2 = Checking account""");
        type = scanner.nextInt();


        current = bank.newAccount(type,isforeign);
        System.out.println("Your new account number is : " + current);
    }

    private void selectAccount(){
        System.out.println("Enter your account number :");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account  " + current + " is : " + balance);
    }

    private void deposit(){
        System.out.println("Enter your deposit amount : ");
        int amt = scanner.nextInt();
        bank.deposit(current, amt);
    }

    private void loan(){
        System.out.println("Enter Loan amt: ");
        int loanAmt = scanner.nextInt();
        if(bank.authorizedLoan(current, loanAmt)){

            System.out.println("Your loan is approved");
        }else{
            System.out.println("Your loan is rejected");
        }
    }

    private void showAll(){
        System.out.println(bank.toString());
    }

    private void interest(){
        bank.addInterest();
    }

    private void setForeign(){
        bank.setForeign(current,requestForeign());
    }

    private boolean requestForeign(){
        System.out.println("""
                    Enter :\s
                     1 = Foreign
                     2 = Domestic""");
        int val = scanner.nextInt();
        return (val == 1);
    }
}
