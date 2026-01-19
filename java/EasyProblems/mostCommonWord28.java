package EasyProblems;

import java.util.*;

public class mostCommonWord28 {

    public static String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b);
        }

        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[^a-z]", " ");


        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = paragraph.split("\\s+");

        for (String word : words) {
            if (word.isEmpty() || bannedSet.contains(word)) {
                continue;
            }
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        String result = "";
        int maxCount = 0;

        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) > maxCount) {
                maxCount = wordCount.get(word);
                result = word;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        String answer = mostCommonWord(paragraph, banned);
        System.out.println("Most common word: " + answer);
    }
}
