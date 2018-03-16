import java.io.*; 

public class Solution {
 private static String mLine;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberTestCases = scanner.nextInt();
        scanner.nextLine();
        while (numberTestCases > 0) {
            parseArguments(scanner);
            numberTestCases--;
            iterate();
        }
}

    public static void parseArguments(Scanner scanner) {
        mLine = scanner.nextLine();
    }

    private static void iterate() {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (char c : mLine.toCharArray()) {
            if (stack.size() > mLine.length() / 2) {
                System.out.println("NO");
                return;
            }
            if (!isClose(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                if (getClose(stack.pop()) != c) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static char getClose(char braket) {
        switch (braket) {
            case '{':
                return '}';
            case '(':
                return ')';
            case '[':
                return ']';
            default:
                return ' ';
        }
    }

    private static boolean isClose(char bracket) {
        return bracket == '}' || bracket == ')' || bracket == ']';
    }
}
