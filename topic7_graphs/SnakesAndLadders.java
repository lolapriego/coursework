import java.io.*;
import java.util.*;

public class Solution {
    private static int mNLad;
    private static int mNSna;
    private static Map<Integer, Integer> mLadPos;
    private static Map<Integer, Integer> mSnaPos;
    private static Map<Integer, Integer> visited;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberTests = scanner.nextInt();
        while (numberTests > 0) {
            parseArguments(scanner);
            System.out.println(printNumberDice());
            numberTests--;
        }
    }

    private static int printNumberDice() {
        Queue<Integer> queue = new LinkedList<>();
        visited = new HashMap<>();
        visited.put(1, 0);
        queue.add(1);
        while(!queue.isEmpty()) {
            Integer element = queue.remove();
            if (element == 100) {
                return visited.get(100);
            }
            for (Integer i = 1; i <= 6; i++) {
                Integer pos = i + element;
                if (mLadPos.containsKey(pos)) {
                    pos = mLadPos.get(pos);
                } else if (mSnaPos.containsKey(pos)) {
                    pos = mSnaPos.get(pos);
                }
                if (visited.get(pos) == null) {
                    visited.put(pos, visited.get(element) + 1);
                    queue.add(pos);
                } else if (visited.get(element) + 1 < visited.get(pos)) {
                    visited.put(pos, visited.get(element + 1));
                }
            }
        }

        return -1;
    }

    private static void parseArguments(Scanner scanner) {
        mNLad = scanner.nextInt();
        int start;
        int end;
        mLadPos = new HashMap<Integer, Integer>(mNLad);
        for (int i = 0; i < mNLad; i++) {
            start = scanner.nextInt();
            end = scanner.nextInt();
            mLadPos.put(start, end);
        }
        mNSna = scanner.nextInt();
        mSnaPos = new HashMap<Integer, Integer>(mNSna);
        for (int i = 0; i < mNSna; i++) {
            start = scanner.nextInt();
            end = scanner.nextInt();
            mSnaPos.put(start, end);
        }
    }

}
