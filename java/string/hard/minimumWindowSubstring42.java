package string.hard;

import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstring42 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int required = target.size();

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int formed = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (target.containsKey(c) &&
                    window.get(c).intValue() == target.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                window.put(leftChar, window.get(leftChar) - 1);
                if (target.containsKey(leftChar) &&
                        window.get(leftChar) < target.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        minimumWindowSubstring42 obj = new minimumWindowSubstring42();

        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Output 1: " + obj.minWindow(s1, t1));

        String s2 = "a";
        String t2 = "a";
        System.out.println("Output 2: " + obj.minWindow(s2, t2));

        String s3 = "a";
        String t3 = "aa";
        System.out.println("Output 3: " + obj.minWindow(s3, t3));
    }
}