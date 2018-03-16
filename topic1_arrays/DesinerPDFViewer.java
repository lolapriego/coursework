import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int designerPdfViewer(int[] h, String word) {
        int maxHeight = 0;
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            // note that characters can be treated as numbers. 'b' -'a' = 1. 
            index = word.charAt(i) - 'a'; 
            if (h[index] > maxHeight) {
                maxHeight = h[index];
            }
        }
        return maxHeight * word.length();
    }

    /**
    * HackerRank provides this code.
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i = 0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int result = designerPdfViewer(h, word);
        System.out.println(result);
        in.close();
    }
}