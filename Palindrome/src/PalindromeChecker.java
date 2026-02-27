import java.util.Scanner;

public class PalindromeChecker {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition: when start crosses or meets end
        if (start >= end) {
            return true;
        }

        // If characters at start and end do not match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call moving towards the center
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Recursive Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Optional: convert to lowercase to make it case-insensitive
        input = input.toLowerCase();

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}