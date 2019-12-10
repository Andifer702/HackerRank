//Starting point and the jumping distance of 2 kangaroos are provided
//Find out if there is at any point if the two kangaroos land at the same spot after same number of jumps
//return YES if there is and return NO if they never meet

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        double jumps = (x1-x2)/(double)(v2-v1);
        if (x1 > x2 && v1 >= v2){
            return "NO";
        } else if ( x2 > x1 && v2 >= v1){
            return "NO";
        } else if (jumps < 0 || jumps != Math.ceil(jumps)){
            return "NO";
        } else {
            return "YES";
        }
        

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
