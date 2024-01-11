import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorBankAccount {

    public static void main(String[] args){
        List<BankAccount> accounts = initAccts();
        Comparator<BankAccount> minBal = new AcctByMinBal();
        Comparator<BankAccount> maxBal = innerClassComp();
        Comparator<BankAccount> minnum = lambdaExpComp1();
        Comparator<BankAccount> maxnum = lambdaExpComp2();

        BankAccount a1 = findMax(accounts,minBal);
        BankAccount a2 = findMax(accounts,maxBal);

        BankAccount a3 = Collections.max(accounts,minnum);
        BankAccount a4 = Collections.max(accounts,maxnum);

        System.out.println(a1.getAcctNum());
        System.out.println(a2.getAcctNum());
        System.out.println(a3.getAcctNum());
        System.out.println(a4.getAcctNum());

    }

    private static BankAccount findMax(List<BankAccount> accounts, Comparator<BankAccount> cmp){
        BankAccount max = accounts.get(0);

        for(int i=1;i<accounts.size();i++){
            if(cmp.compare(accounts.get(i),max)>0)
                max = accounts.get(i);
        }

        return max;
    }
    private static List<BankAccount> initAccts(){
        List<BankAccount> accts =
                new ArrayList<>();
        accts.add(new SavingsAccount(0));
        accts.get(0).deposit(100);
        accts.add(new SavingsAccount(1));
        accts.get(1).deposit(200);
        accts.add(new InterestChecking(2));
        accts.get(2).deposit(50);
        return accts;
    }

    /**Anonymous Inner Class */

    //The rule of abstraction asserts that the type of a variable should be an interface when possible

    private static Comparator<BankAccount> innerClassComp(){
        Comparator<BankAccount> result = new Comparator<BankAccount>() {
            @Override
            public int compare(BankAccount o1, BankAccount o2) {
                int bal1 = o1.getBalance();
                int bal2 = o2.getBalance();
                if(bal1==bal2)
                    return o1.getAcctNum() - o2.getAcctNum();
                else
                    return bal1 - bal2;
            }
        };
        return result;
    }

    /**
     *
     * Lambda Expressions
     *
     * */

    //An interface is said to be functional if it has only one method, not counting any default or static methods
    // -> The interface Comparable<T> is an example of a functional interface
    // -> An anonymous inner class for a functional interface can be written very compactly
    // -> Since there is only one method to define, its name and return type are determined by the interface

    private static Comparator<BankAccount> lambdaExpComp1(){
        Comparator<BankAccount> result = (BankAccount ba1,BankAccount ba2)->{
            return ba2.getAcctNum() -ba1.getAcctNum();
        };
        return result;
    }

    //Another way to define a single statement lambda expression
    private static Comparator<BankAccount> lambdaExpComp2(){
        Comparator<BankAccount> result = (ba1,ba2) ->  ba1.getAcctNum() -ba2.getAcctNum();
        return result;
    }

}
