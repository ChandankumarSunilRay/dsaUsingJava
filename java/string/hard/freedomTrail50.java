package string.hard;

import java.util.*;

public class freedomTrail50 {

    public int findRotateSteps(String ring, String key) {
        int n = ring.length();

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = ring.charAt(i);
            map.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }

        Integer[][] dp = new Integer[n][key.length()];

        return dfs(ring, key, 0, 0, map, dp);
    }

    private int dfs(String ring, String key, int pos, int idx,
                    Map<Character, List<Integer>> map,
                    Integer[][] dp) {

        if (idx == key.length()) return 0;

        if (dp[pos][idx] != null) return dp[pos][idx];

        int n = ring.length();
        char target = key.charAt(idx);
        int minSteps = Integer.MAX_VALUE;

        for (int nextPos : map.get(target)) {

            int diff = Math.abs(pos - nextPos);
            int rotationSteps = Math.min(diff, n - diff);

            int totalSteps = rotationSteps + 1
                    + dfs(ring, key, nextPos, idx + 1, map, dp);

            minSteps = Math.min(minSteps, totalSteps);
        }

        return dp[pos][idx] = minSteps;
    }


    public static void main(String[] args) {
        freedomTrail50 obj = new freedomTrail50();

        String ring1 = "godding";
        String key1 = "gd";
        System.out.println("Output 1: " + obj.findRotateSteps(ring1, key1));

        String ring2 = "godding";
        String key2 = "godding";
        System.out.println("Output 2: " + obj.findRotateSteps(ring2, key2));

        String ring3 = "abcde";
        String key3 = "ade";
        System.out.println("Output 3: " + obj.findRotateSteps(ring3, key3));
    }
}
