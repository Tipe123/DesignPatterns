import java.util.Scanner;


public class NewCmd implements InputCommand{
    @Override
    public int execute(Scanner sc, Bank bank, int current) {

        System.out.println("Enter 1 for foreign" +
                "\n2 for domestic");
        int val = sc.nextInt();

        boolean isforeign = (val == 1);

        int type;

        System.out.println("Enter \n1. Savings account\n2. Checking account\n3. Interest checking");
        type = sc.nextInt();

        current = bank.newAccount(type,isforeign);
        System.out.println("Your new account number is : " + current);

        return current;
    }

    @Override
    public String toString(){
        return "New Account";
    }

}
