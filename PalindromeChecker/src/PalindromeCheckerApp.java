import java.util.*;

public class PalindromeCheckerApp {

    // Stack-based palindrome check
    public static boolean stackPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return input.equals(reversed);
    }

    // Deque-based palindrome check
    public static boolean dequePalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    // Simple reverse method
    public static boolean reversePalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome performance:");
        String input = scanner.nextLine();

        // Stack method timing
        long startStack = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long endStack = System.nanoTime();

        // Deque method timing
        long startDeque = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        long endDeque = System.nanoTime();

        // Reverse method timing
        long startReverse = System.nanoTime();
        boolean reverseResult = reversePalindrome(input);
        long endReverse = System.nanoTime();

        System.out.println("\nResults:");
        System.out.println("Stack Method: " + stackResult +
                " | Time: " + (endStack - startStack) + " ns");

        System.out.println("Deque Method: " + dequeResult +
                " | Time: " + (endDeque - startDeque) + " ns");

        System.out.println("Reverse Method: " + reverseResult +
                " | Time: " + (endReverse - startReverse) + " ns");

        scanner.close();
    }
}