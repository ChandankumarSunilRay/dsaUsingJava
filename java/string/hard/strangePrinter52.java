package string.hard;

public class strangePrinter52 {

    public int strangePrinter(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;

            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i + 1][j] + 1;

                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(i) == s.charAt(k)) {
                        int val = dp[i][k - 1];
                        if (k + 1 <= j) {
                            val += dp[k + 1][j];
                        }
                        dp[i][j] = Math.min(dp[i][j], val);
                    }
                }
            }
        }

        return n == 0 ? 0 : dp[0][n - 1];
    }
    public static void main(String[] args) {
        strangePrinter52 obj = new strangePrinter52();

        String s1 = "aaabbb";
        String s2 = "aba";
        String s3 = "abcba";

        System.out.println("Input: " + s1 + " -> Output: " + obj.strangePrinter(s1));
        System.out.println("Input: " + s2 + " -> Output: " + obj.strangePrinter(s2));
        System.out.println("Input: " + s3 + " -> Output: " + obj.strangePrinter(s3));
    }
}