public class main {

    public static void main(String args[]){
        Sensors sensors = new Sensors(7);


        for(int i=0;i<7;i++){
            if ( i == 5)
                sensors.setSensor(i,true);
            System.out.println(sensors.getSensor(i));
        }
    }
}
