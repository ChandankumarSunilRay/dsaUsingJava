package string.hard;

import java.util.*;

public class concatenatedWords49 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.length() == 0) continue;

            set.remove(word);

            if (canForm(word, set, new HashMap<>())) {
                result.add(word);
            }

            set.add(word);
        }

        return result;
    }
    private boolean canForm(String word, Set<String> set, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);

            if (set.contains(left) &&
                    (set.contains(right) || canForm(right, set, memo))) {
                memo.put(word, true);
                return true;
            }
        }
        memo.put(word, false);
        return false;
    }
    public static void main(String[] args) {
        concatenatedWords49 obj = new concatenatedWords49();

        String[] words1 = {
                "cat", "cats", "catsdogcats", "dog",
                "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"
        };

        List<String> result1 = obj.findAllConcatenatedWordsInADict(words1);
        System.out.println("Output 1: " + result1);

        String[] words2 = {"cat", "dog", "catdog"};

        List<String> result2 = obj.findAllConcatenatedWordsInADict(words2);
        System.out.println("Output 2: " + result2);
    }
}