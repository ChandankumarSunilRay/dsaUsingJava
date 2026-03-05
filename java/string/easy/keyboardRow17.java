package string.easy;

import java.util.*;

public class keyboardRow17 {

    public String[] findWords(String[] words) {

        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        List<String> result = new ArrayList<>();

        for (String word : words) {

            String lower = word.toLowerCase();
            String row = "";

            if (row1.contains("" + lower.charAt(0))) {
                row = row1;
            }
            else if (row2.contains("" + lower.charAt(0))) {
                row = row2;
            }
            else {
                row = row3;
            }

            boolean valid = true;

            for (char c : lower.toCharArray()) {
                if (!row.contains("" + c)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {

        keyboardRow17 obj = new keyboardRow17();

        String[] words = {"Hello", "Alaska", "Dad", "Peace"};

        String[] result = obj.findWords(words);

        System.out.println("Words that can be typed using one keyboard row:");

        for (String word : result) {
            System.out.println(word);
        }
    }
}