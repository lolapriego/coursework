import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] leftRotation(int[] a, int d) {
        // They say in requirements that these inputs should not be considered.
        // However, noting that we should prevent against those.
        if (d == 0 || a.length == 0) {
            return a;
        } 
              
        int rotation = d % a.length;
        if (rotation == 0) return a;

        // Please note that there is an implementation, circular arrays that could be considered here, 
        // but that one has an edge case (Test#1)
        // As, we don't need to optimize for memory, let's keep it simple.
        int [] b = new int[a.length];
        
        for (int i = 0; i < a.length; i++) {
            b[i] = a[indexHelper(i + rotation, a.length)];
        }
        return b;
    }
    
    /**
    * Takes care of the case where the rotation index. Hay que tener en cuenta que como se rota
    * hacia la izquierda, para calcular el index de B rotamos hacia la derecha. Si por el contario
    * hiciéramos a[i] en el for loop, entonces este método tendría que cambiar ligeramente para
    * calcular el index de b.
    */
    private static int indexHelper(int index, int length) {
        if (index >= length) {
            return index - length;
        } else {
            return index;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
