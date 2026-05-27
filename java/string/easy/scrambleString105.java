package string.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class scrambleString105 {

    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        String key = s1 + "#" + s2;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                memo.put(key, false);
                return false;
            }
        }

        int n = s1.length();

        for (int i = 1; i < n; i++) {

            boolean noSwap =
                    isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                            isScramble(s1.substring(i), s2.substring(i));

            if (noSwap) {
                memo.put(key, true);
                return true;
            }

            boolean swap =
                    isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                            isScramble(s1.substring(i), s2.substring(0, n - i));

            if (swap) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        scrambleString105 obj = new scrambleString105();

        boolean result = obj.isScramble(s1, s2);

        System.out.println("Is Scramble String? " + result);

        sc.close();
    }
}

