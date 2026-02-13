package EasyProblems;

import java.util.ArrayList;
import java.util.List;
public class stringMatchingInAnArray53 {

    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {

                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String[] words = {"mass", "as", "hero", "superhero"};

        List<String> result = stringMatching(words);

        System.out.println("Substring words are:");
        for (String word : result) {
            System.out.println(word);
        }
    }
}
