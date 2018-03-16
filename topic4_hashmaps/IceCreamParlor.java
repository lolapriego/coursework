import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] icecreamParlorBasicSolution(int m, int[] arr) {
        int iceCreamOne = 0;
        int iceCreamTwo = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == m) {
                    iceCreamOne = i;
                    iceCreamTwo = j;
                    break;
                }
            }
        }
        iceCreamOne++;
        iceCreamTwo++;
        int iceCreams[] = {iceCreamOne, iceCreamTwo};
        return iceCreams;
    }

    // If we think about it, this turns into a search problem. We are trying to look to
    // elements such as m = element1 + element2; for each item in the array (element1),
    // element2 will be m - element1. Knowing that, instead of having an inner loop (for inside of a for loop)
    // that will take O(N ^ 2) to run, we can take a little bit of memory hit, and create a hashMap with
    // each of the items of the array to avoid the second loop. Let's look at the solution.
    static int[] icecreamParlor(int m, int[] arr) {
        int iceCreamOne = 0;
        int iceCreamTwo = 0;
        Map<Integer, List<Integer>> costToIndex = createMap(arr);
        // This loop will take O(n) time to run. Much faster than the previous
        // solution :)
        for (int i = 0; i < arr.length - 1; i++) {
            if (costToIndex.containsKey(m - arr[i])) {
                iceCreamOne = i;
                iceCreamTwo = costToIndex.get(m - arr[i]).get(0);
                // In the case where we need two different IceCreams of the same price.
                if (iceCreamTwo == iceCreamOne) {
                    if (costToIndex.get(m - arr[i]).size() > 1) {
                        iceCreamTwo = costToIndex.get(m - arr[i]).get(1);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        iceCreamOne++;
        iceCreamTwo++;
        int [] iceCreams = {iceCreamOne, iceCreamTwo};
        return iceCreams;
    }

    private static Map<Integer, List<Integer>> createMap(int arr []) {
        Map<Integer, List<Integer>> costToIndex = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            // They say that some elements might have the same cost. And
            // in that case they always prefer the lower ID (index).
            // Therefore, if the cost is already in our map, we will append it into a
            // LinkedList
            if (!costToIndex.containsKey(arr[i])) {
                List<Integer> indexList = new LinkedList<Integer>();
                indexList.add(i);
                costToIndex.put(arr[i], indexList);
            } else {
                costToIndex.get(arr[i]).add(i);
            }
        }
        return costToIndex;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = icecreamParlor(m, arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}
