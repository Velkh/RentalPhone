package rentPhone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class rent extends mainRun {

    public static void writeRent() throws IOException {
        String rentPrint = "";
        FileWriter rP = new FileWriter(rentFile);
        for(int i = 0 ; i < Algorithm.phone.length ; i++){
            rentPrint = rentPrint + Algorithm.phone[i] + "\n";
        }
     rP.write(rentPrint);
     rP.close();
    }
    public static void printRent( String a, String b, String c, String d, String e ) throws IOException {
    FileWriter rP = new FileWriter(rentFile);
    rP.write(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n");
    rP.close();

    }

}
