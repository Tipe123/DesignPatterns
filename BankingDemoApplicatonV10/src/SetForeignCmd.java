import java.util.Scanner;

public class SetForeignCmd implements InputCommand{
    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.println("Enter 1 for foreign" +
                "\n2 for domestic");
        int val = sc.nextInt();
        bank.setForeign(current,(val == 1));

        return current;
    }

    @Override
    public String toString(){
        return "Set foreign";
    }
}
