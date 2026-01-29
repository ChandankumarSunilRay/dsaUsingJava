package EasyProblems;
import java.util.*;
public class findCommonCharacters38 {

    public static List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];

        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] freq = new int[26];
            for (char c : words[i].toCharArray()) {
                freq[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], freq[j]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i]-- > 0) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String[] words1 = {"bella", "label", "roller"};
        System.out.println(commonChars(words1));

        String[] words2 = {"cool", "lock", "cook"};
        System.out.println(commonChars(words2));
    }
}




