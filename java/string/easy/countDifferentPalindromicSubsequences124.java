package string.easy;

public class countDifferentPalindromicSubsequences124 {

    private static final int MOD = 1_000_000_007;

    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        long[][] dp = new long[n][n];

        int[][] next = new int[n][4];
        int[][] prev = new int[n][4];

        int[] last = {-1, -1, -1, -1};
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
            for (int c = 0; c < 4; c++) {
                prev[i][c] = last[c];
            }
        }

        last = new int[]{-1, -1, -1, -1};
        for (int i = n - 1; i >= 0; i--) {
            last[s.charAt(i) - 'a'] = i;
            for (int c = 0; c < 4; c++) {
                next[i][c] = last[c];
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (s.charAt(i) != s.charAt(j)) {

                    dp[i][j] = dp[i + 1][j]
                            + dp[i][j - 1]
                            - dp[i + 1][j - 1];

                } else {

                    int ch = s.charAt(i) - 'a';

                    int low = (i + 1 < n) ? next[i + 1][ch] : -1;
                    int high = (j - 1 >= 0) ? prev[j - 1][ch] : -1;

                    if (low == -1 || low > j - 1) {

                        long middle = (i + 1 <= j - 1)
                                ? dp[i + 1][j - 1]
                                : 0;

                        dp[i][j] = middle * 2 + 2;

                    }
                    else if (low == high) {

                        long middle = (i + 1 <= j - 1)
                                ? dp[i + 1][j - 1]
                                : 0;

                        dp[i][j] = middle * 2 + 1;

                    }
                    else {

                        long middle = (i + 1 <= j - 1)
                                ? dp[i + 1][j - 1]
                                : 0;

                        dp[i][j] = middle * 2
                                - dp[low + 1][high - 1];
                    }
                }

                dp[i][j] %= MOD;
                if (dp[i][j] < 0) {
                    dp[i][j] += MOD;
                }
            }
        }

        return (int) dp[0][n - 1];
    }

    public static void main(String[] args) {

        countDifferentPalindromicSubsequences124 solver =
                new countDifferentPalindromicSubsequences124();

        String s1 = "bccb";
        System.out.println("Input : " + s1);
        System.out.println("Output: "
                + solver.countPalindromicSubsequences(s1));

        String s2 = "abcdabcdabcdabcdabcdabcdabcdabcd";
        System.out.println("Input : " + s2);
        System.out.println("Output: "
                + solver.countPalindromicSubsequences(s2));
    }
}