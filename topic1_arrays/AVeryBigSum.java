import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /**
    * Your solution in here. Just need to add the number in a variable type long so you
    * don't face overflow.
    */
    static long aVeryBigSum(int n, long[] ar) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ar[i];
        }
        return sum;
    }

    /**
    * HackerRank provides this code.
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ar = new long[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextLong();
        }
        long result = aVeryBigSum(n, ar);
        System.out.println(result);
    }
}
