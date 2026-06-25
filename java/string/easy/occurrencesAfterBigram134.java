package string.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class occurrencesAfterBigram134 {

    public String[] findOccurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                result.add(words[i + 2]);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        occurrencesAfterBigram134 solution = new occurrencesAfterBigram134();

        String text1 = "alice is a good girl she is a good student";
        String first1 = "a";
        String second1 = "good";

        String[] result1 = solution.findOccurrences(text1, first1, second1);
        System.out.println("Test Case 1 Output: " + Arrays.toString(result1));

        String text2 = "we will we will rock you";
        String first2 = "we";
        String second2 = "will";

        String[] result2 = solution.findOccurrences(text2, first2, second2);
        System.out.println("Test Case 2 Output: " + Arrays.toString(result2));
    }
}