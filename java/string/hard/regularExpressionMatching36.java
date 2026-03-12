package string.hard;

public class regularExpressionMatching36 {

    static Boolean[][] memo;

    public static boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p);
    }

    private static boolean dfs(int i, int j, String s, String p) {

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (j == p.length()) {
            return memo[i][j] = (i == s.length());
        }

        boolean firstMatch = (i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            boolean skip = dfs(i, j + 2, s, p);

            boolean use = firstMatch && dfs(i + 1, j, s, p);

            memo[i][j] = skip || use;
            return memo[i][j];
        }

        if (firstMatch) {
            memo[i][j] = dfs(i + 1, j + 1, s, p);
            return memo[i][j];
        }

        memo[i][j] = false;
        return false;
    }

    public static void main(String[] args) {

        String s1 = "aa";
        String p1 = "a";
        System.out.println("Input: s = " + s1 + ", p = " + p1);
        System.out.println("Output: " + isMatch(s1, p1));

        String s2 = "aa";
        String p2 = "a*";
        System.out.println("Input: s = " + s2 + ", p = " + p2);
        System.out.println("Output: " + isMatch(s2, p2));

        String s3 = "ab";
        String p3 = ".*";
        System.out.println("Input: s = " + s3 + ", p = " + p3);
        System.out.println("Output: " + isMatch(s3, p3));
    }
}