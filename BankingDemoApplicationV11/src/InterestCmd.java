import java.util.Scanner;


public class InterestCmd implements InputCommand{
    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        bank.addInterest();
        return current;
    }

    @Override
    public String toString(){
        return "Interest";
    }
}
