public class IntProcessor1 {

    private Operation op;
    public IntProcessor1(Operation op){
        this.op = op;
    }

    public void operateOn(int x){
        int y = f(x);
        System.out.println(x +" becomes " +y);
    }

    private int f(int x){
        return op.f(x);
    }

}
