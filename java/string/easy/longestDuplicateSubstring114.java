package string.easy;

import java.util.HashSet;
import java.util.Scanner;

public class longestDuplicateSubstring114 {

    public String longestDupSubstring(String s) {
        int n = s.length();

        int left = 1;
        int right = n - 1;

        int start = -1;
        int maxLen = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int idx = search(s, mid);

            if (idx != -1) {
                start = idx;
                maxLen = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return start == -1 ? "" : s.substring(start, start + maxLen);
    }

    private int search(String s, int len) {
        int n = s.length();

        long mod = 1_000_000_007L;
        long base = 31;

        long hash = 0;
        long power = 1;


        for (int i = 0; i < len; i++) {
            hash = (hash * base + (s.charAt(i) - 'a' + 1)) % mod;

            if (i < len - 1) {
                power = (power * base) % mod;
            }
        }

        HashSet<Long> seen = new HashSet<>();
        seen.add(hash);

        for (int i = len; i < n; i++) {

            int outgoing = s.charAt(i - len) - 'a' + 1;
            int incoming = s.charAt(i) - 'a' + 1;

            hash = (hash - outgoing * power % mod + mod) % mod;
            hash = (hash * base + incoming) % mod;

            if (seen.contains(hash)) {
                return i - len + 1;
            }

            seen.add(hash);
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        longestDuplicateSubstring114 solution =
                new longestDuplicateSubstring114();

        String result = solution.longestDupSubstring(s);

        System.out.println("Longest Duplicate Substring: \"" + result + "\"");

        sc.close();
    }
}