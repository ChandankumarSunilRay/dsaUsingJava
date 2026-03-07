package string.easy;



public class detectCapital22 {
    public static boolean detectCapitalUse(String word) {
        int upperCount = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upperCount++;
            }
        }

        if (upperCount == word.length()) {
            return true;
        }

        if (upperCount == 0) {
            return true;
        }

        if (upperCount == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String word1 = "USA";
        String word2 = "leetcode";
        String word3 = "Google";
        String word4 = "FlaG";

        System.out.println(word1 + " -> " + detectCapitalUse(word1));
        System.out.println(word2 + " -> " + detectCapitalUse(word2));
        System.out.println(word3 + " -> " + detectCapitalUse(word3));
        System.out.println(word4 + " -> " + detectCapitalUse(word4));
    }
}

