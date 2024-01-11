import java.io.*;

public class EncryptDecrypt {

    public static void main(String[] args) throws IOException{
//        int offset = 26;
//        encrypt("data.txt","encrypt.txt",offset);
//        encrypt("encrypt.txt","data.txt",-offset);

        byte y = 'b'+29;


        System.out.println(y);

//        byte[] a = new byte[16];
//        InputStream is = new FileInputStream("data.txt");
//        int howmany = is.read(a);
//        System.out.println("First "+howmany);
//        System.out.println(a.length);
//        if (howmany == a.length) {
//            howmany = is.read(a, 0, 7);
//            System.out.println("second "+howmany);
//        }
    }

    public static void encrypt(String source, String output, int offset) throws IOException{

        try(InputStream is = new FileInputStream(source) ;
            OutputStream os = new FileOutputStream(output)){
            int x;

            while ((x = is.read()) >= 0){
                byte b = (byte) x;
                b+=offset;
                os.write(b);
            }
        }

    }

}
