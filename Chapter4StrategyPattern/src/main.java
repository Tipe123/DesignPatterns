public class main {

    public static void main(String[] args){
        IntProcessor p1 = new AddOne();
        IntProcessor p2 = new AddTwo();
        IntProcessor p3 = new AddThree();
        p1.operateOn(6);
        p2.operateOn(6);
        p3.operateOn(6);


        System.out.println("\nNow with the use of Strategy Design Pattern \n");
        Operation op1 = new AddOne1();
        Operation op2 = new AddTwo1();
        Operation op3 = new AddThree1();

        IntProcessor1 ip1 = new IntProcessor1(op1);
        IntProcessor1 ip2 = new IntProcessor1(op2);
        IntProcessor1 ip3 = new IntProcessor1(op3);

        ip1.operateOn(6);
        ip2.operateOn(6);
        ip3.operateOn(6);
    }

}
