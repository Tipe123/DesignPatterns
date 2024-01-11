import java.util.Scanner;

public class ShowCmd implements InputCommand{
    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.println(bank.toString());
        return current;
    }

    @Override
    public String toString(){
        return "Show accounts";
    }
}
