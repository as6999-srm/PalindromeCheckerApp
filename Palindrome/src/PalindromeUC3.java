public class PalindromeUC3 {

    public static void main(String[] args) {

        String original = "level";
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        System.out.println("Original String : " + original);
        System.out.println("Reversed String : " + reversed);

        if (original.equals(reversed)) {
            System.out.println("Result: The string \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("Result: The string \"" + original + "\" is NOT a Palindrome.");
        }

        System.out.println("Program executed successfully.");
    }
}
