package string.hard;

public class wildcardMatching38 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1)) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        wildcardMatching38 matcher = new wildcardMatching38();

        String s1 = "aa", p1 = "a";
        System.out.println("Input: s = \"" + s1 + "\", p = \"" + p1 + "\" => " + matcher.isMatch(s1, p1));

        String s2 = "aa", p2 = "*";
        System.out.println("Input: s = \"" + s2 + "\", p = \"" + p2 + "\" => " + matcher.isMatch(s2, p2));

        String s3 = "cb", p3 = "?a";
        System.out.println("Input: s = \"" + s3 + "\", p = \"" + p3 + "\" => " + matcher.isMatch(s3, p3));

        String s4 = "adceb", p4 = "*a*b";
        System.out.println("Input: s = \"" + s4 + "\", p = \"" + p4 + "\" => " + matcher.isMatch(s4, p4));
    }
}