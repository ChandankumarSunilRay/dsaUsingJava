package string.easy;

public class interleavingString116 {

    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i > 0
                        && dp[i - 1][j]
                        && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                }

                if (j > 0
                        && dp[i][j - 1]
                        && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        interleavingString116 solution = new interleavingString116();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        boolean result = solution.isInterleave(s1, s2, s3);

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
        System.out.println("Is Interleaving? " + result);


        System.out.println(
                solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));

        System.out.println(
                solution.isInterleave("", "", ""));
    }
}