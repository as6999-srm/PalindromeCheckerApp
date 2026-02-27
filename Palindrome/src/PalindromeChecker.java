import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {

    /* ===============================
       Stack Based Approach
       =============================== */
    public static boolean stackMethod(String input) {

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : cleaned.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : cleaned.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    /* ===============================
       Deque Based Approach
       =============================== */
    public static boolean dequeMethod(String input) {

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : cleaned.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    /* ===============================
       Two Pointer Approach (Optimized)
       =============================== */
    public static boolean twoPointerMethod(String input) {

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /* ===============================
       Main Method
       =============================== */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (UC13 - Performance Comparison) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Stack Method Timing
        long start1 = System.nanoTime();
        boolean result1 = stackMethod(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // Deque Method Timing
        long start2 = System.nanoTime();
        boolean result2 = dequeMethod(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // Two Pointer Timing
        long start3 = System.nanoTime();
        boolean result3 = twoPointerMethod(input);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        System.out.println("\n=== Results ===");
        System.out.println("Stack Method Result: " + result1 + " | Time: " + time1 + " ns");
        System.out.println("Deque Method Result: " + result2 + " | Time: " + time2 + " ns");
        System.out.println("Two Pointer Method Result: " + result3 + " | Time: " + time3 + " ns");

        scanner.close();
    }
}