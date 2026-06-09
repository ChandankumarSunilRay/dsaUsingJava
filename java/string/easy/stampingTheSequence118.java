package string.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class stampingTheSequence118 {

    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();

        int m = s.length;
        int n = t.length;

        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();

        int stars = 0;

        while (stars < n) {
            boolean changed = false;

            for (int i = 0; i <= n - m; i++) {

                if (!visited[i] && canReplace(t, s, i)) {

                    stars += replaceWithStars(t, i, m);

                    visited[i] = true;
                    changed = true;

                    result.add(i);

                    if (stars == n) {
                        break;
                    }
                }
            }

            if (!changed) {
                return new int[0];
            }
        }

        int[] answer = new int[result.size()];
        int index = 0;

        for (int i = result.size() - 1; i >= 0; i--) {
            answer[index++] = result.get(i);
        }

        return answer;
    }

    private boolean canReplace(char[] target, char[] stamp, int pos) {
        boolean hasNonStar = false;

        for (int i = 0; i < stamp.length; i++) {

            if (target[pos + i] == '*') {
                continue;
            }

            if (target[pos + i] != stamp[i]) {
                return false;
            }

            hasNonStar = true;
        }

        return hasNonStar;
    }

    private int replaceWithStars(char[] target, int pos, int len) {
        int replaced = 0;

        for (int i = 0; i < len; i++) {
            if (target[pos + i] != '*') {
                target[pos + i] = '*';
                replaced++;
            }
        }

        return replaced;
    }

    public static void main(String[] args) {

        stampingTheSequence118 solution = new stampingTheSequence118();

        String stamp1 = "abc";
        String target1 = "ababc";

        int[] result1 = solution.movesToStamp(stamp1, target1);

        System.out.println("Example 1:");
        System.out.println("Stamp  = " + stamp1);
        System.out.println("Target = " + target1);
        System.out.println("Output = " + Arrays.toString(result1));

        System.out.println();

        String stamp2 = "abca";
        String target2 = "aabcaca";

        int[] result2 = solution.movesToStamp(stamp2, target2);

        System.out.println("Example 2:");
        System.out.println("Stamp  = " + stamp2);
        System.out.println("Target = " + target2);
        System.out.println("Output = " + Arrays.toString(result2));
    }
}