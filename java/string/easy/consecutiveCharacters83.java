package string.easy;

public class consecutiveCharacters83 {

    public static int maxPower(String s) {
        if (s == null || s.length() == 0) return 0;

        int max = 1;
        int curr = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                curr = 1;
            }
            max = Math.max(max, curr);
        }

        return max;
    }

    public static void main(String[] args) {
        String test1 = "leetcode";
        String test2 = "abbcccddddeeeeedcba";
        String test3 = "aaaaa";

        System.out.println("Input: " + test1 + " -> Output: " + maxPower(test1));
        System.out.println("Input: " + test2 + " -> Output: " + maxPower(test2));
        System.out.println("Input: " + test3 + " -> Output: " + maxPower(test3));
    }
}