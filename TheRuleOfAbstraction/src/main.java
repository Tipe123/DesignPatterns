import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        for(int i = 0 ; i < 10; i++){
            words.add(scanner.next());
        }
        Collections.sort(words,null);

        System.out.println("Using the Collections interface to sort");
        System.out.println(words);

        words.sort(null);

        System.out.println("Using the List interface to sort");
        System.out.println(words);
    }

}
