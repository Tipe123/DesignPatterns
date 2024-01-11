import java.util.Scanner;

public class BankClient {

    private int current = -1;
    private Scanner scanner ;
    private boolean done = false;

    private Bank bank ;

    //Constructor injection
    public BankClient(Scanner scanner, Bank bank) {
        this.scanner = scanner;
        this.bank = bank;
    }

    public void run() {

        while(!done){
            System.out.println("Enter commands : " +
                    "\n 0 = quit" +
                    "\n 1 = new" +
                    "\n 2 = select" +
                    "\n 3 = deposit" +
                    "\n 4 = loan" +
                    "\n 5 = show" +
                    "\n 6 = interest" +
                    "\n 7 = set foreign");
            int command = scanner.nextInt();
            processCommand(command);
        }

    }

    private void processCommand(int command){
        switch(command){
            case 0:
                quit();
                break;
            case 1:
                createNewAccount();
                break;
            case 2:
                selectAccount();
                break;
            case 3:
                deposit();
                break;
            case 4:
                loan();
                break;
            case 5:
                showAll();
                break;
            case 6:
                interest();
                break;
            case 7:
                setForeign();
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }

    private void quit(){
        done = true;
    }

    private void createNewAccount(){
        boolean isforeign = requestForeign();
        current = bank.newAccount(isforeign);
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
        System.out.println("Enter 1 for roreign" +
                "\n2 for domestic");
        int val = scanner.nextInt();
        return (val == 1);
    }
}
