import java.util.Scanner;
import java.util.Stack;


class PalindromeChecker {

    // Encapsulated method to check palindrome
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize the string (remove spaces & convert to lowercase)
        String cleanedInput = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < cleanedInput.length(); i++) {
            stack.push(cleanedInput.charAt(i));
        }

        // Compare characters while popping from stack
        for (int i = 0; i < cleanedInput.length(); i++) {
            if (cleanedInput.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Main Application Class
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeChecker palindromeChecker = new PalindromeChecker();

        System.out.println("=== Palindrome Checker App (UC11) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = palindromeChecker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}