import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeChecker {



        public static void main(String[] args) {



            Scanner scanner = new Scanner(System.in);

            System.out.println("======================================");
            System.out.println("   UC7: Deque Optimized Palindrome Check");
            System.out.println("======================================");

            System.out.print("Enter a string to check: ");
            String input = scanner.nextLine();

            // Normalize input (remove spaces and convert to lowercase)
            input = input.replaceAll("\\s+", "").toLowerCase();

            Deque<Character> deque = new LinkedList<>();

            // Insert characters into deque
            for (char ch : input.toCharArray()) {
                deque.addLast(ch);  // Insert at rear
            }

            boolean isPalindrome = true;

            // Compare front and rear
            while (deque.size() > 1) {

                char front = deque.removeFirst();  // Remove from front
                char rear = deque.removeLast();    // Remove from rear

                if (front != rear) {
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




