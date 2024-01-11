import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankProgram {

    public static void main(String[] args){

        SavedBankInfo info = new SavedBankInfo("bank.txt");


        Map<Integer,BankAccount> accounts = info.getAccounts();
        int nextacct = info.nextAccountNumber();
        Bank bank = new Bank(accounts,nextacct);
        Scanner scanner = new Scanner(System.in);

        // Constructor injection
        BankClient client = new BankClient(scanner,bank);

        client.run();

        info.saveMap(accounts, info.nextAccountNumber());
    }

}

