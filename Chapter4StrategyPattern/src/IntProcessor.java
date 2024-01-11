public abstract class IntProcessor {

    public void operateOn(int x){
        int y = f(x);
        System.out.println(x +" becomes "+y);
    }

    private int f(int x){
        return x + this.addedValue();
    };


    protected abstract int addedValue();
}
