package string.hard;

import java.util.HashMap;
import java.util.Map;

public class countTheRepetitions46 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length(), len2 = s2.length();

        int j = 0;
        int count = 0;

        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < n1; i++) {

            for (int k = 0; k < len1; k++) {
                if (s1.charAt(k) == s2.charAt(j)) {
                    j++;
                    if (j == len2) {
                        j = 0;
                        count++;
                    }
                }
            }

            if (map.containsKey(j)) {
                int[] prev = map.get(j);
                int prev_i = prev[0];
                int prev_count = prev[1];

                int cycleLen = i - prev_i;
                int cycleCount = count - prev_count;

                int remaining = n1 - i - 1;

                int cycles = remaining / cycleLen;

                count += cycles * cycleCount;
                i += cycles * cycleLen;
            } else {
                map.put(j, new int[]{i, count});
            }
        }

        return count / n2;
    }

    public static void main(String[] args) {
        countTheRepetitions46 obj = new countTheRepetitions46();

        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 2;

        int result1 = obj.getMaxRepetitions(s1, n1, s2, n2);
        System.out.println("Example 1 Output: " + result1);

        s1 = "acb";
        n1 = 1;
        s2 = "acb";
        n2 = 1;

        int result2 = obj.getMaxRepetitions(s1, n1, s2, n2);
        System.out.println("Example 2 Output: " + result2);

        s1 = "aaa";
        n1 = 3;
        s2 = "aa";
        n2 = 1;

        int result3 = obj.getMaxRepetitions(s1, n1, s2, n2);
        System.out.println("Custom Output: " + result3);
    }
}