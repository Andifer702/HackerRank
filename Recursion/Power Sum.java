//Find the number of ways that a given integer X, ,X can be expressed as the sum of the Nth powers of unique, natural numbers.
//For example, if X = 13  and N = 2, we have to find all combinations of unique squares adding up to 13. The only solution is 2^2 + 3^2 = 13.
//output would be 1

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the powerSum function below.
    static int powerSum(int X, int N, int currentBase) {
        int currentPower = (int) Math.pow(currentBase, N);
        if (currentPower == X){
            return 1;
        } else if (currentPower > X) {
            return 0;
        } else {
            return powerSum(X, N, currentBase + 1) + powerSum(X - currentPower, N, currentBase + 1);
        }


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int currentBase = 1;
        int result = powerSum(X, N, currentBase);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
