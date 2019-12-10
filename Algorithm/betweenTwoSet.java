//given a two set of numbers, find a set of integers that will divisible by the first set of numbers
//And at the same time, evenly divide the second set of numbers.
//For example, [2,6] and [24,36] will be 6 and 12. The numbers can be both divided by the numbers in the first set
//At the same time, 6 and 12 can both evenly divide 24 and 36

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        int counter = 0;
        int leastNum = lcm(a);
        int greatNum = gcd(b);
        for (int i = leastNum, j = 1; i <= greatNum; j++){
            i = leastNum * j; //find multiple of the LCM that is divisible by the GCD from 2nd set of numbers
	        if(greatNum%i ==0 ) {
	        	counter += 1;
	        }
        }

        return counter;
    }
    
    //The rule of this algorithm is to find the least common multiple from the first set of numbers
    //And the greatest common divisor from the second set of the numbers.
    //Then find the multiples from the LCM to GCD that is evenly divides.
    
    //below are the gcd and lcm methods

    public static int gcd (int a, int b){
        while (b>0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public static int gcd(List<Integer> a){
        int result = a.get(0);
        for (int i = 1; i < a.size(); i++){
            result = gcd(result, a.get(i));
        }
        return result;
    }

    public static int lcm(int a, int b){
        return a*(b/gcd(a,b));
    }

    public static int lcm(List<Integer> a){
        int result = a.get(0);
        for(int i = 1; i < a.size(); i++){
            result = lcm(result, a.get(i));
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
