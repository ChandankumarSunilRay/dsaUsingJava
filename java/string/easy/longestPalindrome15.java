package string.easy;

import java.util.Scanner;

public class longestPalindrome15 {

    public int longestPalindrome(String s) {
        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int c : count) {
            if (c % 2 == 0) {
                length += c;
            } else {
                length += c - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) {
            length += 1;
        }

        return length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = sc.nextLine();

        longestPalindrome15 obj = new longestPalindrome15();
        int result = obj.longestPalindrome(input);

        System.out.println("Longest Palindrome Length: " + result);

        sc.close();
    }
}