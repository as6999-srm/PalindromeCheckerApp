
import java.util.Stack;

public class PalindromeUC5 {/**
 * UseCase5PalindromeCheckerApp
 * -----------------------------------------
 * This program checks whether a string is a
 * palindrome using a Stack (LIFO principle).
 *
 * Version: 1.0
 */



        public static void main(String[] args) {

            // Original String
            String input = "madam";

            // Create Stack
            Stack<Character> stack = new Stack<>();

            // Push characters into stack
            for (int i = 0; i < input.length(); i++) {
                stack.push(input.charAt(i));
            }

            boolean isPalindrome = true;

            // Pop and compare with original string
            for (int i = 0; i < input.length(); i++) {
                char poppedChar = stack.pop();

                if (input.charAt(i) != poppedChar) {
                    isPalindrome = false;
                    break;
                }
            }

            // Display result
            System.out.println("Input String : " + input);

            if (isPalindrome) {
                System.out.println("Result: The string \"" + input + "\" is a Palindrome.");
            } else {
                System.out.println("Result: The string \"" + input + "\" is NOT a Palindrome.");
            }

            System.out.println("Program executed successfully.");
        }
    }


