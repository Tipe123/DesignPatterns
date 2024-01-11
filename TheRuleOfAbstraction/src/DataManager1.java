import java.util.ArrayList;
import java.util.Collections;

public class DataManager1 {

    private ArrayList<Double> data;

    public DataManager1(ArrayList<Double> data){
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
