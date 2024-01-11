import java.util.Scanner;

public class SelectCmd implements InputCommand {
    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.println("Enter your account number :");
        current = sc.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account  " + current + " is : " + balance);

        return current;
    }

    @Override
    public String toString(){
        return "Select Account";
    }
}
