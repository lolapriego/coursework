import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int totalN = Integer.parseInt(scanner.nextLine());
        final Map<String, Integer> mapWords = buildCollectionOfStrings(scanner, totalN);
        final int numberQueries = Integer.parseInt(scanner.nextLine());
        printOcurrenceOfQueries(scanner, numberQueries, mapWords);
    }

    /**
    * Este mêtodo construye un mapa con la colección de Strings y las veces que aparece
    * cada una
    */
    private static Map<String, Integer> buildCollectionOfStrings(Scanner scanner, int n) {
        final Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            final String line = scanner.nextLine();
            if (map.containsKey(line)) {
                map.put(line, map.get(line) + 1);
            } else {
                map.put(line, 1);
            }
        }
        return map;
    }

    private static void printOcurrenceOfQueries(Scanner scanner, int numberQueries, Map<String, Integer> mapWords) {
        for (int i = 0; i < numberQueries; i++) {
          // por cada query, buscamos cuántas veces ha aparecido e imprimimos por pantalla el valor.
            final String line = scanner.nextLine();
            if (mapWords.containsKey(line)) {
                System.out.println(mapWords.get(line));
            } else {
                System.out.println(0);
            }
        }
    }
}
