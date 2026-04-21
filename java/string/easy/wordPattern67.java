package string.easy;

import java.util.HashMap;
import java.util.Map;

public class wordPattern67 {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(ch, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch) {
                    return false;
                }
            } else {
                wordToChar.put(word, ch);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        wordPattern67 obj = new wordPattern67();

        String pattern1 = "abba";
        String s1 = "dog cat cat dog";

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";

        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";

        System.out.println("Test 1: " + obj.wordPattern(pattern1, s1));
        System.out.println("Test 2: " + obj.wordPattern(pattern2, s2));
        System.out.println("Test 3: " + obj.wordPattern(pattern3, s3));
    }
};