import java.io.*;
import java.util.*;

public class Solution {
    static class Node {
        int value;
        int left;
        int right;
        int depth;
    }

    private static List<Node> mNodes;
    private static int maxDepth = 0;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberNodes = scanner.nextInt();
        scanner.nextLine();
        mNodes = new ArrayList<>(numberNodes);

        buildTree(numberNodes, scanner);
        int t = Integer.parseInt(scanner.nextLine());
        while (t > 0) {
            performSwap(scanner);
            t--;
        }
    }

    private static void buildTree(int numberNodes, Scanner scanner) {
        Node root = new Node();
        root.depth = 1;
        mNodes.add(root);
        for (int i = 1; i <= numberNodes; i++) {
            String line = scanner.nextLine();
            Node node = mNodes.get(i - 1);
            node.value = i;
            int leftPos = Integer.parseInt(line.split(" ")[0]);
            int rightPos = Integer.parseInt(line.split(" ")[1]);
            if (leftPos != -1) {
                addLeftNode(node, leftPos);
            }
             if (rightPos != -1) {
                addRightNode(node, rightPos);
            }
            node.left = leftPos;
            node.right = rightPos;
        }
    }

    private static void addLeftNode(Node node, int leftPos) {
        Node left = new Node();
        left.depth = node.depth + 1;
        if (left.depth > maxDepth) {
            maxDepth = left.depth;
        }
        mNodes.add(leftPos - 1, left);
    }

    private static void addRightNode(Node node, int rightPos) {
        Node right = new Node();
        right.depth = node.depth + 1;
        if (right.depth > maxDepth) {
            maxDepth = right.depth;
        }
        mNodes.add(rightPos - 1, right);
    }

    private static void performSwap(Scanner scanner) {
        int k = Integer.parseInt(scanner.nextLine());
        for (int i = k; i <= maxDepth; i += k) {
            for (Node node : mNodes) {
                if (node.depth == i) {
                    int tmp = node.left;
                    node.left = node.right;
                    node.right  = tmp;
                }
            }
        }
        printInOrder(mNodes.get(0));
        System.out.println();
    }
    private static void printInOrder(Node node) {
        if (node == null || node.value == -1) {
            return;
        }
        if (node.left != -1) {
            printInOrder(mNodes.get(node.left - 1));
        }
        System.out.print(node.value + " ");
        if (node.right != -1) {
            printInOrder(mNodes.get(node.right - 1));
        }
    }
}
