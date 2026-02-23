package string.easy;

import java.util.HashSet;
import java.util.Set;

public class uniqueMorseCodeWords2 {

    public static int uniqueMorseRepresentations(String[] words) {

        String[] morse = {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
                "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
                "..-","...-",".--","-..-","-.--","--.."
        };

        Set<String> uniqueTransformations = new HashSet<>();

        for (String word : words) {
            StringBuilder transformation = new StringBuilder();

            for (char c : word.toCharArray()) {
                transformation.append(morse[c - 'a']);
            }

            uniqueTransformations.add(transformation.toString());
        }

        return uniqueTransformations.size();
    }

    public static void main(String[] args) {

        String[] words1 = {"gin", "zen", "gig", "msg"};
        int result1 = uniqueMorseRepresentations(words1);
        System.out.println("Output for example 1: " + result1);

        String[] words2 = {"a"};
        int result2 = uniqueMorseRepresentations(words2);
        System.out.println("Output for example 2: " + result2);
    }
}