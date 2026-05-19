package string.easy;

import java.util.*;

public class uncommonWordsfromTwoSentences97 {
    public String[] uncommonFromSentences(String s1, String s2) {

        HashMap<String, Integer> map = new HashMap<>();

        String[] arr1 = s1.split(" ");

        for (String word : arr1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        String[] arr2 = s2.split(" ");

        for (String word : arr2) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>();

        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                list.add(word);
            }
        }

        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        uncommonWordsfromTwoSentences97 obj =
                new uncommonWordsfromTwoSentences97();

        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";

        String[] result = obj.uncommonFromSentences(s1, s2);

        System.out.println("Uncommon Words:");

        for (String word : result) {
            System.out.print(word + " ");
        }
    }
}