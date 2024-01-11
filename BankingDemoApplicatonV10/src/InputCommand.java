import java.util.Scanner;

public interface InputCommand {
    public abstract int execute(Scanner sc , Bank bank, int current);
}
