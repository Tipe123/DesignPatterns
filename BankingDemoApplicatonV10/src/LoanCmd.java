import java.util.Scanner;

public class LoanCmd implements InputCommand {
    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.println("Enter Loan amt: ");
        int loanAmt = sc.nextInt();

        System.out.println(bank.authorizedLoan(current,loanAmt) ? "Your loan is approved" : "Your loan is rejected");

        return current;
    }

    @Override
    public String toString(){
        return "Loan ";
    }
}
