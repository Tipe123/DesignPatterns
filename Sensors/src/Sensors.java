import java.util.ArrayList;
import java.util.List;

public class Sensors {

    private List<Boolean> L = new ArrayList<>();

    public Sensors(int size){
        //Instead of using a deprecated new Boolen(False)
        // we use Boolean.FALSE, a static value that stores a new Boolean(False) value
        for(int i =0;i<size;i++)
            L.add(Boolean.FALSE);
    }

    public void setSensor(int n,boolean  b){
        Boolean val = Boolean.valueOf(b);
        L.set(n,val);
    }
    public boolean getSensor(int n){
        Boolean val = L.get(n);
        return val.booleanValue();
    }

}
