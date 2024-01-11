import java.util.Scanner;

public class QuitCmd implements InputCommand{
    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        return -1;
    }
    @Override
    public String toString(){
        return "Quit";
    }
}
