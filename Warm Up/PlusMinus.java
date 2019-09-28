/* 
Given an array of integers, calculate the fractions of its elements that are positive, negative, and are zeros. 
Print the decimal value of each fraction on a new line.
Note: This challenge introduces precision problems. 
The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double positive = 0;
        double negative = 0;
        double zero = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 0){
                positive += 1;
            } else if (arr[i] < 0) {
                negative += 1;
            } else {
                zero += 1;
            }
        }
        System.out.printf("%.6f %n", positive/arr.length);
        System.out.printf("%.6f %n", negative/arr.length);
        System.out.printf("%.6f %n", zero/arr.length);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
