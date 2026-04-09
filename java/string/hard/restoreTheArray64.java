package string.hard;

public class restoreTheArray64 {

    static final int MOD = 1_000_000_007;

    public int numberOfArrays(String s, int k) {
        int n = s.length();
        long[] dp = new long[n + 1];

        dp[n] = 1; // base case

        for (int i = n - 1; i >= 0; i--) {

            if (s.charAt(i) == '0') continue;

            long num = 0;

            for (int j = i; j < n; j++) {
                num = num * 10 + (s.charAt(j) - '0');

                if (num > k) break;

                dp[i] = (dp[i] + dp[j + 1]) % MOD;
            }
        }

        return (int) dp[0];
    }

    public static void main(String[] args) {
        restoreTheArray64 obj = new restoreTheArray64();

        String s1 = "1000";
        int k1 = 10000;
        System.out.println("Output 1: " + obj.numberOfArrays(s1, k1));

        String s2 = "1000";
        int k2 = 10;
        System.out.println("Output 2: " + obj.numberOfArrays(s2, k2));

        String s3 = "1317";
        int k3 = 2000;
        System.out.println("Output 3: " + obj.numberOfArrays(s3, k3));

        String s4 = "123456";
        int k4 = 1000;
        System.out.println("Output 4: " + obj.numberOfArrays(s4, k4));
    }
}
