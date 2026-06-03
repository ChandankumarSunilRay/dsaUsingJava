package string.easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class K_SimilarStrings112 {

    public int kSimilarity(String s1, String s2) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s1);
        visited.add(s1);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String current = queue.poll();

                if (current.equals(s2)) {
                    return level;
                }

                int i = 0;
                while (i < current.length() && current.charAt(i) == s2.charAt(i)) {
                    i++;
                }

                char[] chars = current.toCharArray();

                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] == s2.charAt(i) && chars[j] != s2.charAt(j)) {
                        swap(chars, i, j);

                        String next = new String(chars);

                        if (visited.add(next)) {
                            queue.offer(next);
                        }

                        swap(chars, i, j);
                    }
                }
            }

            level++;
        }

        return -1;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        K_SimilarStrings112 obj = new K_SimilarStrings112();

        String s1 = "abc";
        String s2 = "bca";

        int result = obj.kSimilarity(s1, s2);

        System.out.println("Minimum swaps: " + result);
    }
}