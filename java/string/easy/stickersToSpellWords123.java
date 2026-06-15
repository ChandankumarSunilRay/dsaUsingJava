package string.easy;
import java.util.HashMap;
import java.util.Map;
public class stickersToSpellWords123 {

    public int minStickers(String[] stickers, String target) {

        int n = stickers.length;
        int[][] stickerCount = new int[n][26];

        for (int i = 0; i < n; i++) {
            for (char ch : stickers[i].toCharArray()) {
                stickerCount[i][ch - 'a']++;
            }
        }

        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);

        return dfs(target, stickerCount, memo);
    }

    private int dfs(String target,
                    int[][] stickerCount,
                    Map<String, Integer> memo) {

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int[] need = new int[26];

        for (char ch : target.toCharArray()) {
            need[ch - 'a']++;
        }

        int answer = Integer.MAX_VALUE;

        for (int[] sticker : stickerCount) {


            char firstChar = target.charAt(0);

            if (sticker[firstChar - 'a'] == 0) {
                continue;
            }

            StringBuilder remaining = new StringBuilder();

            for (int i = 0; i < 26; i++) {

                int left = need[i] - sticker[i];

                while (left > 0) {
                    remaining.append((char) ('a' + i));
                    left--;
                }
            }

            String nextTarget = remaining.toString();

            int subProblem = dfs(nextTarget, stickerCount, memo);

            if (subProblem != -1) {
                answer = Math.min(answer, 1 + subProblem);
            }
        }

        int result = (answer == Integer.MAX_VALUE) ? -1 : answer;
        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {

        stickersToSpellWords123 solution = new stickersToSpellWords123();

        String[] stickers1 = {"with", "example", "science"};
        String target1 = "thehat";

        System.out.println("Example 1 Output: "
                + solution.minStickers(stickers1, target1));

        String[] stickers2 = {"notice", "possible"};
        String target2 = "basicbasic";

        System.out.println("Example 2 Output: "
                + solution.minStickers(stickers2, target2));

        String[] stickers3 = {"these", "guess", "about", "garden", "him"};
        String target3 = "atomher";

        System.out.println("Custom Test Output: "
                + solution.minStickers(stickers3, target3));
    }
}