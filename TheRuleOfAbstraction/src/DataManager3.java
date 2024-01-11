import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DataManager3 {

    private Collection<Double> data;

    public DataManager3(Collection<Double> data){
        this.data = data;
    }

    public double max(){
        return Collections.max(data);
    }

    private double mean(){
        double sum = 0.0;

        for(double d : data){
            sum += d;
        }

        return sum;
    }

}
