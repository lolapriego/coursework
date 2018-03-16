import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] quickSort(int[] arr) {
        int pivotValue = arr[0];
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < pivotValue) {
                left.add(arr[i]);
            } else {
                right.add(arr[i]);
            }
        }
        printArray(left);
        System.out.print(pivotValue + " ");
        printArray(right);
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = quickSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
    private static void printArray(List<Integer> ar) {
        for(int n: ar){
            System.out.print(n + " ");
        }
    }
}
