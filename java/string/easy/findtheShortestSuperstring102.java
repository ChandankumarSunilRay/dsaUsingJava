package string.easy;

import java.util.*;

public class findtheShortestSuperstring102 {

    public String shortestSuperstring(String[] words) {

        int n = words.length;

        int[][] overlap = new int[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (i == j) continue;

                int maxLen = Math.min(words[i].length(), words[j].length());

                for (int k = maxLen; k >= 0; k--) {

                    if (words[i].substring(words[i].length() - k)
                            .equals(words[j].substring(0, k))) {

                        overlap[i][j] = k;
                        break;
                    }
                }
            }
        }

        int N = 1 << n;

        int[][] dp = new int[N][n];
        int[][] parent = new int[N][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        for (int[] row : parent)
            Arrays.fill(row, -1);

        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
        }

        for (int mask = 0; mask < N; mask++) {

            for (int last = 0; last < n; last++) {

                if (dp[mask][last] == -1) continue;

                for (int next = 0; next < n; next++) {

                    if ((mask & (1 << next)) != 0) continue;

                    int newMask = mask | (1 << next);

                    int value = dp[mask][last] + overlap[last][next];

                    if (value > dp[newMask][next]) {

                        dp[newMask][next] = value;
                        parent[newMask][next] = last;
                    }
                }
            }
        }

        int fullMask = N - 1;

        int last = 0;

        for (int i = 1; i < n; i++) {

            if (dp[fullMask][i] > dp[fullMask][last]) {
                last = i;
            }
        }

        List<Integer> path = new ArrayList<>();

        int mask = fullMask;

        while (last != -1) {

            path.add(last);

            int prev = parent[mask][last];

            mask ^= (1 << last);

            last = prev;
        }

        Collections.reverse(path);

        StringBuilder ans = new StringBuilder(words[path.get(0)]);

        for (int i = 1; i < path.size(); i++) {

            int a = path.get(i - 1);
            int b = path.get(i);

            ans.append(words[b].substring(overlap[a][b]));
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        findtheShortestSuperstring102 obj =
                new findtheShortestSuperstring102();

        String[] words1 = {"alex", "loves", "leetcode"};

        System.out.println("Example 1:");
        System.out.println(obj.shortestSuperstring(words1));

        String[] words2 = {"catg", "ctaagt", "gcta", "ttca", "atgcatc"};

        System.out.println("\nExample 2:");
        System.out.println(obj.shortestSuperstring(words2));
    }
}