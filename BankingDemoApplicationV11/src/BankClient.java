import java.util.Scanner;

public class BankClient {

    private int current = -1;
    private Scanner scanner ;
    private boolean done = false;

    private Bank bank ;

    private InputCommand[] commands ={
            new QuitCmd(),
            new NewCmd(),
            new SelectCmd(),
            new Deposit(),
            new LoanCmd(),
            new ShowCmd(),
            new InterestCmd(),
            new SetForeignCmd()
    };

    //Constructor injection
    public BankClient(Scanner scanner, Bank bank) {
        this.scanner = scanner;
        this.bank = bank;
    }

    public void run() {

        String userMessage = constructMessage();
        while(!done){

            System.out.println(userMessage);
            int command = scanner.nextInt();
            processCommand(command);
        }

    }

    private String constructMessage(){
        String result = "Enter the Command :" ;
        for(int i = 0 ; i<commands.length;i++){
            result += "\n" + i + " = " + commands[i] ;
        }
        return result;
    }

    private void processCommand(int command){
        InputCommand cmd = commands[command];
        current = cmd.execute(scanner,bank,current);
        if (current < 0)
            done = true;
    }



}
