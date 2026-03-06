package string.easy;

public class validPalindromell19 {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
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
        validPalindromell19 obj = new validPalindromell19();

        String s1 = "aba";
        String s2 = "abca";
        String s3 = "abc";

        System.out.println(s1 + " -> " + obj.validPalindrome(s1));
        System.out.println(s2 + " -> " + obj.validPalindrome(s2));
        System.out.println(s3 + " -> " + obj.validPalindrome(s3));
    }
}