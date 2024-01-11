import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataManager2 {

    private List<Double> data;

    public DataManager2(List<Double> data){
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
