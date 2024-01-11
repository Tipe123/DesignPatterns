import java.util.Scanner;

public enum InputCommands implements  InputCommand{

    //We use lambda expression since InputCommand interface contains one method

    QUIT("Quit" ,(sc,bank,current)->{
        sc.close();
        System.out.println("Goodbye!");
        return  -1;
    }),
    NEW("New account",(sc,bank,current)->{
        System.out.println("Enter Account Type" +
                "\n1. Savings." +
                "\n2. checking." +
                "\n3. interest checking");
        int type = sc.nextInt();
        boolean isForeign = requestForeign(sc);
        current = bank.newAccount(type,isForeign);
        System.out.println("Your new account number is : " + current);

        return current;
    }),
    SELECT("select", (sc, bank, current)->{
        System.out.print("Enter account#: ");
        current = sc.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account " + current
                + " is " + balance);
        return current;
    }),
    DEPOSIT("deposit", (sc, bank, current)->{
        System.out.print("Enter deposit amount: ");
        int amt = sc.nextInt();
        bank.deposit(current, amt);
        return current;
    }),
    LOAN("loan", (sc, bank, current)->{
        System.out.print("Enter loan amount: ");
        int amt = sc.nextInt();
        boolean ok = bank.authorizedLoan(current, amt);
        if (ok)
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");
        return current;
    }),
    SHOW("show", (sc, bank, current)->{
        System.out.println(bank.toString());
        return current;
    }),
    INTEREST("interest", (sc, bank, current)-> {
        bank.addInterest();
        return current;
    }),
    SET_FOREIGN("setforeign", (sc, bank, current)-> {
        bank.setForeign(current, requestForeign(sc));
        return current;
    })
    ;


    private String name;
    private InputCommand cmd;

    InputCommands(String name, InputCommand cmd) {
        this.name = name;
        this.cmd = cmd;
    }

    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        return cmd.execute(sc, bank, current);
    }

    @Override
    public String toString(){
        return this.name;
    }

    private static boolean requestForeign(Scanner sc){
        System.out.println("Enter \n1. for Foreign \n" +
                "2. for Domestic");
        int val = sc.nextInt();

        return (val==1);
    }
}
