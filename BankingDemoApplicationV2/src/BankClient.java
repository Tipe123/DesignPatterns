import java.util.Scanner;

public class BankClient {

    private int current = -1;
    private Scanner scanner = new Scanner(System.in);
    private boolean done = false;

    //Dependency injection
    private Bank bank = new Bank();

    public void run() {

        while(!done){
            System.out.println("Enter commands : " +
                    "\n 0 = quit" +
                    "\n 1 = new" +
                    "\n 2 = select" +
                    "\n 3 = deposit" +
                    "\n 4 = loan" +
                    "\n 5 = show" +
                    "\n 6 = interest");
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
            default:
                System.out.println("Invalid command");
                break;
        }
    }

    private void quit(){
        done = true;
    }

    private void createNewAccount(){
        current = bank.newAccount();

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
        if(bank.authorizeloan(current, loanAmt)){
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
}
