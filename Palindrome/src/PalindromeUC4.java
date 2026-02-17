public class PalindromeUC4 {



        public static void main(String[] args) {

            // Original String
            String input = "radar";

            // Convert String to character array
            char[] characters = input.toCharArray();

            // Two-pointer approach
            int start = 0;
            int end = characters.length - 1;

            boolean isPalindrome = true;

            while (start < end) {

                if (characters[start] != characters[end]) {
                    isPalindrome = false;
                    break;
                }

                start++;
                end--;
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



