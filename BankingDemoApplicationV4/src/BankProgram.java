import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class BankProgram {

    public static void main(String[] args){
        HashMap<Integer,BankAccount> accounts = new HashMap<>();

        int nextact = 0;
        Bank bank = new Bank(accounts,nextact);
        Scanner scanner = new Scanner(System.in);

        // Constructor injection
        BankClient client = new BankClient(scanner,bank);

        client.run();
    }

}

