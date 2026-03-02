package string.easy;

import java.util.Scanner;

public class isSebsequence9 {
    public static boolean isSubsequence(String s, String t) {
        int i = 0; // pointer for s
        int j = 0; // pointer for t

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // move pointer in s if match
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = scanner.nextLine();

        System.out.print("Enter string t: ");
        String t = scanner.nextLine();

        boolean result = isSubsequence(s, t);

        System.out.println("Is \"" + s + "\" a subsequence of \"" + t + "\"? " + result);

        scanner.close();
    }
}