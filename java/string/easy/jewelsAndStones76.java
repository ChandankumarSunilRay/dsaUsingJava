package string.easy;

import java.util.HashSet;

public class jewelsAndStones76 {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();

        for (char c : jewels.toCharArray()) {
            set.add(c);
        }

        int count = 0;

        for (char c : stones.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        jewelsAndStones76 obj = new jewelsAndStones76();

        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        System.out.println("Output 1: " + obj.numJewelsInStones(jewels1, stones1));

        String jewels2 = "z";
        String stones2 = "ZZ";
        System.out.println("Output 2: " + obj.numJewelsInStones(jewels2, stones2));
    }
}