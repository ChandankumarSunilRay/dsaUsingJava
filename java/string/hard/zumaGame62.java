package string.hard;

import java.util.*;

public class zumaGame62 {
    private Map<String, Integer> memo = new HashMap<>();

    public int findMinStep(String board, String hand) {
        int[] count = new int[26];
        for (char c : hand.toCharArray()) {
            count[c - 'A']++;
        }
        int res = dfs(board, count);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int dfs(String board, int[] hand) {
        board = shrink(board);
        if (board.length() == 0) return 0;

        String key = board + "#" + Arrays.toString(hand);
        if (memo.containsKey(key)) return memo.get(key);

        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= board.length(); i++) {
            for (char c = 'A'; c <= 'Z'; c++) {
                if (hand[c - 'A'] == 0) continue;

                if (i > 0 && board.charAt(i - 1) == c) continue;

                boolean useful = false;

                if (i < board.length() && board.charAt(i) == c) {
                    useful = true;
                }
                if (i > 0 && i < board.length()
                        && board.charAt(i - 1) == board.charAt(i)
                        && board.charAt(i) != c) {
                    useful = true;
                }
                if (!useful) continue;
                hand[c - 'A']--;
                String next = board.substring(0, i) + c + board.substring(i);
                int sub = dfs(next, hand);

                if (sub != Integer.MAX_VALUE) {
                    res = Math.min(res, sub + 1);
                }
                hand[c - 'A']++;
            }
        }
        memo.put(key, res);
        return res;
    }
    private String shrink(String s) {
        int i = 0;
        for (int j = 0; j <= s.length(); j++) {
            if (j == s.length() || s.charAt(j) != s.charAt(i)) {
                if (j - i >= 3) {
                    return shrink(s.substring(0, i) + s.substring(j));
                }
                i = j;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        zumaGame62 obj = new zumaGame62();

        String board1 = "RRWWRRBBRR";
        String hand1 = "WB";
        System.out.println("Output 1: " + obj.findMinStep(board1, hand1));

        String board2 = "WRRBBW";
        String hand2 = "RB";
        System.out.println("Output 2: " + obj.findMinStep(board2, hand2));

        String board3 = "WWRRBBWW";
        String hand3 = "WRBRW";
        System.out.println("Output 3: " + obj.findMinStep(board3, hand3));

        String board4 = "G";
        String hand4 = "GGGGG";
        System.out.println("Output 4: " + obj.findMinStep(board4, hand4));
    }
}