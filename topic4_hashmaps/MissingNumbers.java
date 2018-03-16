import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void missingNumbers(int[] arr, int[] brr) {
        int min = findMin(brr);
        // If we know the min, now we can save the ocurrence of each number in an array
        // We will use the index as a representation of a number. E.g. if the list would
        // contain elements from 200 to 300 range, if we see 205, we will increment index 5
        // by 1.

        int [] occurrence = new int[101];
        int index;
        for (int i : brr) {
            index = i - min;
            occurrence[index]++;
        }

        // Now we have a list that tells us how many times each number occur.
        // We can build the same list for A and then compare. Or we can iterate
        // A the same way and decrement everytime we see the number.
        for (int i : arr) {
            index = i - min;
            occurrence[index]--;
        }


        // Now all the indexes with value > 0 are those who are actually missing.
        for (int i = 0; i < 100; i++) {
            if (occurrence[i] > 0) {
                index = i + min;
                System.out.print(index + " ");
            }
        }
        System.out.println("");
    }

    private static int findMin(int[] brr) {
      // They state that the max value that we can find is 10 ^ 4 -- let's just
      // go with this.
        int min = Integer.MAX_VALUE;
        for (int i : brr) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] brr = new int[m];
        for(int brr_i = 0; brr_i < m; brr_i++){
            brr[brr_i] = in.nextInt();
        }

        missingNumbers(arr, brr);


        in.close();
    }
}
