import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the staircase function below.
    //create N number of steps of stairs using "#" character with right alignment
    //each step increases the number of # to build a stair
    
    static void staircase(int n) {
        int spaceNum = n-1;

        for (int i = 1; i <= n; i++){
            //create a string with repeating white spaces and repeating stair character depending on the iteration
            String whiteSpace = new String(new char[spaceNum]).replace("\0", " "); 
            String lineTree = new String(new char[i]).replace("\0", "#");
            System.out.println(whiteSpace + lineTree);
            spaceNum -= 1;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
