package string.easy;

public class removepalindromic84 {

    public int removePalindromeSub(String s) {
        if (isPalindrome(s)) {
            return 1;
        }
        return 2;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        removepalindromic84 obj = new removepalindromic84();

        String[] testCases = {
                "ababa",
                "abb",
                "baabb",
                "a",
                "b",
                "abab"
        };

        for (String s : testCases) {
            int result = obj.removePalindromeSub(s);
            System.out.println("Input: " + s + " -> Output: " + result);
        }
    }
}