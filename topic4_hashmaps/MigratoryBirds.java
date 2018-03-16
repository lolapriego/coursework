import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int migratoryBirds(int n, int[] ar) {
        if (n == 0) {
            return 1;
        }
        int [] counters = new int[5];
        for (int i = 0; i < n; i++) {
            counters[ar[i] - 1]++;
        }
        int max = counters[4];
        //last one, recuerda que solo hay 5 tipos. El index del tipo5, es 4.
        int maxType = 5;
        for (int i = 4; i >= 0; i--) {
            if (counters[i] >= max) {
                max = counters[i];
                maxType = i + 1;
            }
        }
        return maxType;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
