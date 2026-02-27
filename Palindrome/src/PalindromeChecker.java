import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/* =========================
   Strategy Interface
   ========================= */
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

/* =========================
   Stack-based Strategy
   ========================= */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {

        if (input == null) return false;

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cleaned.length(); i++) {
            stack.push(cleaned.charAt(i));
        }

        for (int i = 0; i < cleaned.length(); i++) {
            if (cleaned.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

/* =========================
   Deque-based Strategy
   ========================= */
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {

        if (input == null) return false;

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
}

/* =========================
   Context Class
   ========================= */
class PalindromeContext {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.isPalindrome(input);
    }
}

/* =========================
   Main Application
   ========================= */
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("=== Palindrome Checker App (UC12 - Strategy Pattern) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\nChoose Palindrome Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                context.setStrategy(new StackStrategy());
                break;
            case 2:
                context.setStrategy(new DequeStrategy());
                break;
            default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
        }

        boolean result = context.executeStrategy(input);

        if (result) {
            System.out.println("\nResult: The given string is a Palindrome.");
        } else {
            System.out.println("\nResult: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}