package string.easy;

import java.util.*;
public class wordLadder99 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(beginWord, 1));

        set.remove(beginWord);

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            String word = current.word;
            int steps = current.steps;

            if (word.equals(endWord)) {
                return steps;
            }

            for (int i = 0; i < word.length(); i++) {

                char[] arr = word.toCharArray();
                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    arr[i] = ch;

                    String newWord = new String(arr);

                    if (set.contains(newWord)) {

                        queue.offer(new Pair(newWord, steps + 1));

                        set.remove(newWord);
                    }
                }

                arr[i] = original;
            }
        }

        return 0;
    }
    static class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
                "hot", "dot", "dog", "lot", "log", "cog"
        );

        int ans = ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest Transformation Length: " + ans);
    }
}