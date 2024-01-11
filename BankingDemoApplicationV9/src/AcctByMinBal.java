import java.util.Comparator;

public class AcctByMinBal implements Comparator<BankAccount> {

    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        int bal1 = o1.getBalance();
        int bal2 = o2.getBalance();
        if(bal1==bal2)
            return o1.getAcctNum() - o2.getAcctNum();
        else
            return bal2 - bal1;
    }
}
