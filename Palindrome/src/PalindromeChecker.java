import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeChecker {



        public static void main(String[] args) {



            Node class for Singly Linked List
            static class Node {
                char data;
                Node next;

                Node(char data) {
                    this.data = data;
                    this.next = null;
                }
            }

            // Function to reverse a linked list
            public static Node reverse(Node head) {
                Node prev = null;
                Node current = head;
                Node next = null;

                while (current != null) {
                    next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                }

                return prev;
            }

            // Function to check palindrome
            public static boolean isPalindrome(Node head) {

                if (head == null || head.next == null)
                    return true;

                Node slow = head;
                Node fast = head;

                // Find middle using fast & slow pointers
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }

                // Reverse second half
                Node secondHalf = reverse(slow);

                Node firstHalf = head;
                Node tempSecond = secondHalf;

                // Compare both halves
                while (tempSecond != null) {
                    if (firstHalf.data != tempSecond.data) {
                        return false;
                    }
                    firstHalf = firstHalf.next;
                    tempSecond = tempSecond.next;
                }

                return true;
            }

            public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("======================================");
                System.out.println("   UC8: Linked List Palindrome Check");
                System.out.println("======================================");

                System.out.print("Enter a string to check: ");
                String input = scanner.nextLine();

                // Normalize input
                input = input.replaceAll("\\s+", "").toLowerCase();

                // Convert string to linked list
                Node head = null;
                Node tail = null;

                for (char ch : input.toCharArray()) {
                    Node newNode = new Node(ch);

                    if (head == null) {
                        head = newNode;
                        tail = newNode;
                    } else {
                        tail.next = newNode;
                        tail = newNode;
                    }
                }

                boolean result = isPalindrome(head);

                if (result) {
                    System.out.println("Result: The string is a Palindrome ✅");
                } else {
                    System.out.println("Result: The string is NOT a Palindrome ❌");
                }

                scanner.close();
                }
            }




