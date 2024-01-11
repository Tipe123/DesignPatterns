import java.util.Scanner;

public class Deposit implements InputCommand {
    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.println("Enter deposit amount :");
        int amt = sc.nextInt();
        bank.deposit(current,amt);
        return current;
    }

    @Override
    public String toString(){
        return "Deposit";
    }
}

