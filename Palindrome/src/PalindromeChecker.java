import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;


public class PalindromeChecker {



        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("======================================");
            System.out.println("   UC6: Queue + Stack Palindrome Check");
            System.out.println("======================================");

            System.out.print("Enter a string to check: ");
            String input = scanner.nextLine();


            // Convert to lowercase and remove spaces for uniform comparison
            input = input.replaceAll("\\s+", "").toLowerCase();

            Queue<Character> queue = new LinkedList<>();
            Stack<Character> stack = new Stack<>();

            // Enqueue and Push characters
            for (char ch : input.toCharArray()) {
                queue.add(ch);      // Enqueue (FIFO)
                stack.push(ch);     // Push (LIFO)
            }

            boolean isPalindrome = true;

            // Compare dequeue and pop
            while (!queue.isEmpty()) {
                char fromQueue = queue.remove();  // Dequeue
                char fromStack = stack.pop();     // Pop

                if (fromQueue != fromStack) {
                    isPalindrome = false;
                    break;
                }
            }

            // Display Result
            if (isPalindrome) {
                System.out.println("Result: The string is a Palindrome ");
            } else {
                System.out.println("Result: The string is NOT a Palindrome ");
            }

            scanner.close();
        }
    }

