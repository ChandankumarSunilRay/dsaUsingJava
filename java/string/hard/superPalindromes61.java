package string.hard;

public class superPalindromes61 {

    public int superpalindromesInRange(String left, String right) {
        long L = Long.parseLong(left);
        long R = Long.parseLong(right);

        int count = 0;

        for (int i = 1; i < 100000; i++) {

            long p = createPalindrome(i, true);
            long square = p * p;
            if (square > R) break;

            if (square >= L && isPalindrome(square)) {
                count++;
            }

            p = createPalindrome(i, false);
            square = p * p;

            if (square <= R && square >= L && isPalindrome(square)) {
                count++;
            }
        }

        return count;
    }

    private long createPalindrome(int num, boolean oddLength) {
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);

        int start = oddLength ? s.length() - 2 : s.length() - 1;

        for (int i = start; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return Long.parseLong(sb.toString());
    }

    private boolean isPalindrome(long num) {
        String s = Long.toString(num);
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        superPalindromes61 obj = new superPalindromes61();

        String left1 = "4";
        String right1 = "1000";
        System.out.println("Output: " + obj.superpalindromesInRange(left1, right1));

        String left2 = "1";
        String right2 = "2";
        System.out.println("Output: " + obj.superpalindromesInRange(left2, right2));

        String left3 = "1";
        String right3 = "1000000000000000000";
        System.out.println("Output: " + obj.superpalindromesInRange(left3, right3));
    }
}