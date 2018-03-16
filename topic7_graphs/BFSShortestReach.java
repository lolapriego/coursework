import java.io.*;
import java.util.*;

public class Solution {
    private static int mN;
    private static int mM;
    private static Integer mS;
    private static Map<Integer, Set<Integer>> mNodeToNeigh;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberTests = scanner.nextInt();
        while (numberTests > 0) {
            parseArguments(scanner);
            computeOutput();
            numberTests--;
        }
    }

    private static void computeOutput() {
        Queue<Integer> queue = new LinkedList<Integer>();
        Map<Integer, Integer> visitedMinDis = new HashMap<>();
        visitedMinDis.put(mS, 0);
        queue.add(mS);

        while(!queue.isEmpty()) {
            Integer element = queue.remove();

            if (mNodeToNeigh.get(element) != null) {
                for(Integer neigh : mNodeToNeigh.get(element)) {
                    if(!visitedMinDis.containsKey(neigh)) {
                        queue.add(neigh);
                        visitedMinDis.put(neigh, visitedMinDis.get(element) + 1);
                    } else if(visitedMinDis.get(neigh) > visitedMinDis.get(element) + 1) {
                        visitedMinDis.put(neigh, visitedMinDis.get(element) + 1);
                    }
                }
            }
        }

        for (Integer i = 1; i <= mN; i++) {
            if (!i.equals(mS)) {
                Integer dis = visitedMinDis.get(i);
                if (dis == null) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(dis * 6 + " ");
                }
            }
        }
        System.out.println();
    }

    private static void parseArguments(Scanner scanner) {
        mN = scanner.nextInt();
        mM = scanner.nextInt();

        mNodeToNeigh = new HashMap<>(mM);
        int x;
        int y;
        for (int i = 0; i < mM; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            Set<Integer> neighX;
            if(mNodeToNeigh.get(x) == null) {
                neighX = new HashSet<Integer>();
            } else {
                neighX = mNodeToNeigh.get(x);
            }
            neighX.add(y);
            mNodeToNeigh.put(x, neighX);

            Set<Integer> neighY;
            if(mNodeToNeigh.get(y) == null) {
                neighY = new HashSet<Integer>();
            } else {
                neighY = mNodeToNeigh.get(y);
            }
            neighY.add(x);
            mNodeToNeigh.put(y, neighY);
        }
        mS = new Integer(scanner.nextInt());
    }
}
