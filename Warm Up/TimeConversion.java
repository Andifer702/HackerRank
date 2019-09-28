//Given a time in -hour AM/PM format, convert it to military (24-hour) time. hh:mm:ssAM / hh:mm:ssPM
//Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. 
..Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String[] ar = s.split(":");
        if(ar[2].contains("PM") && !ar[0].equals("12")){
            ar[0] = Integer.toString(Integer.parseInt(ar[0]) + 12);
        } else if (ar[2].contains("AM") && ar[0].equals("12")){
            ar[0] ="00";
        }
        ar[2] = ar[2].substring(0,2);

        return ar[0] + ":" + ar[1] + ":" + ar[2];
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
