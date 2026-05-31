package string.easy;

public class distinctSubsequences109 {

    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        long[] dp = new long[n + 1];
        dp[0] = 1; // empty string can always be formed

        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j + 1] += dp[j];
                }
            }
        }

        return (int) dp[n];
    }

    public static void main(String[] args) {

        String s1 = "rabbbit";
        String t1 = "rabbit";

        String s2 = "babgbag";
        String t2 = "bag";

        System.out.println(numDistinct(s1, t1));
        System.out.println(numDistinct(s2, t2));
    }
}