import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BankingProgram {

    private HashMap<Integer,Integer> accounts = new HashMap<>();
    private double rate = 0.01;
    private int nextacct = 0;
    private int current = -1; // The global variable current keeps track of the current account.
    private Scanner scanner;
    private boolean done = false;

    public static void main(String[] args){
        BankingProgram program = new BankingProgram();
        program.run();
    }

    public void run() {
        scanner = new Scanner(System.in);
        while(!done){
            System.out.println("Enter Commands :" +
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
        scanner.close();
    }

    public void processCommand(int command){
        switch(command){
            case 0:
                quit();
                break;
            case 1:
                newAccount();
                break;
            case 2:
                select();
                break;
            case 3:
                deposit();
                break;
            case 4:
                loan();
                break;
            case 5:
                show();
                break;
            case 6:
                interest();
                break;
            default:
                System.out.println("Invalid Command");
                break;
        }
    }

    private void quit(){

        done = true;
        System.out.println("GoodByw!!!");

    }

    private void newAccount(){
        current = ++nextacct;
        accounts.put(current, 0);
        System.out.println("New Account Created and is :" + current);
    }

    private void select(){
        System.out.println("Enter the account number : ");
        current = scanner.nextInt();

        System.out.println("The balance of Account " + current +" is :" + accounts.get(current) );
    }

    private void deposit(){
        System.out.println("Enter Deposit amount :");
        int amount = scanner.nextInt();
        accounts.put(current, accounts.get(current) + amount);
    }

    private void loan(){

        System.out.println("Enter Loan Amount :" );
        int amount = scanner.nextInt();
        if(accounts.get(current) >= amount/2)
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");

    }

    private void show(){
        Set<Integer> accts = accounts.keySet();

        System.out.println("The bank has " + accts.size() + " accounts");
        for(int i : accts){
            System.out.println("\tAccount " + i + " has balance " + accounts.get(i));
        }
    }

    private void interest() {
        Set<Integer> accts = accounts.keySet();

        for (int i : accts) {
            accounts.put(i, (int) (accounts.get(i) * (1 + rate)));
        }
    }

}
