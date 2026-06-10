package string.easy;

public class shortestPalindrome119 {

    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = new int[combined.length()];

        for (int i = 1; i < combined.length(); i++) {
            int j = lps[i - 1];

            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }

            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        int longestPalindromicPrefix = lps[combined.length() - 1];

        String remaining = s.substring(longestPalindromicPrefix);
        return new StringBuilder(remaining).reverse().toString() + s;
    }

    public static void main(String[] args) {
        shortestPalindrome119 solution = new shortestPalindrome119();

        String[] testCases = {
                "aacecaaa",
                "abcd",
                "race",
                "aaab",
                "",
                "a"
        };

        for (String s : testCases) {
            System.out.println("Input  : " + s);
            System.out.println("Output : " + solution.shortestPalindrome(s));
            System.out.println("-------------------------");
        }
    }
}