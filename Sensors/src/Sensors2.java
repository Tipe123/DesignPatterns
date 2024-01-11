import java.util.ArrayList;
import java.util.List;

public class Sensors2 {

    private List<Boolean> L = new ArrayList<>();
    private static final Boolean off = Boolean.FALSE;
    private static final Boolean on = Boolean.TRUE;

    public Sensors2(int size) {
        for(int i=0;i<size;i++)
            L.add(off);
    }

    public boolean getSensor(int n){
        Boolean val = L.get(n);
        return val.booleanValue();
    }

    public void setSensor(int n,boolean b){
        Boolean val = b ? on : off;
        L.set(n,val);
    }
}
