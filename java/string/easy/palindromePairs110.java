package string.easy;

import java.util.*;

public class palindromePairs110 {

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        Map<String, Integer> wordIndex = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            wordIndex.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            for (int cut = 0; cut <= word.length(); cut++) {

                String left = word.substring(0, cut);
                String right = word.substring(cut);

                if (isPalindrome(left)) {
                    String reverseRight =
                            new StringBuilder(right).reverse().toString();

                    Integer index = wordIndex.get(reverseRight);

                    if (index != null && index != i) {
                        result.add(Arrays.asList(index, i));
                    }
                }
                if (cut != word.length() && isPalindrome(right)) {
                    String reverseLeft =
                            new StringBuilder(left).reverse().toString();

                    Integer index = wordIndex.get(reverseLeft);

                    if (index != null && index != i) {
                        result.add(Arrays.asList(i, index));
                    }
                }
            }
        }

        return result;
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String[] words1 = {"abcd", "dcba", "lls", "s", "sssll"};

        List<List<Integer>> result = palindromePairs(words1);

        System.out.println("Palindrome Pairs:");
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }

    }
}