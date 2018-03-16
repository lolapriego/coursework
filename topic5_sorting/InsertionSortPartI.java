import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void insertionSort1(int n, int[] arr) {
        int elementToSort = arr[arr.length - 1];
        int index = arr.length - 1;
        while (index > 0) {
            if (arr[index - 1] < elementToSort) {
                break;
            }
            arr[index] = arr[index - 1];
            printArray(arr);
            index--;
        }
        arr[index] = elementToSort;
        printArray(arr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort1(n, arr);
        in.close();
    }

    private static void printArray(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
