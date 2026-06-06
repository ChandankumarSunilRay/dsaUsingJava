package string.easy;

public class verifyinganAlienDictionary115 {

    public boolean isAlienSorted(String[] words, String order) {

        int[] rank = new int[26];


        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }


        for (int i = 0; i < words.length - 1; i++) {
            if (!isInCorrectOrder(words[i], words[i + 1], rank)) {
                return false;
            }
        }

        return true;
    }

    private boolean isInCorrectOrder(String word1, String word2, int[] rank) {

        int minLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLength; i++) {

            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if (c1 == c2) {
                continue;
            }

            return rank[c1 - 'a'] < rank[c2 - 'a'];
        }


        return word1.length() <= word2.length();
    }

    public static void main(String[] args) {

        verifyinganAlienDictionary115 solution =
                new verifyinganAlienDictionary115();


        String[] words1 = {"hello", "leetcode"};
        String order1 = "hlabcdefgijkmnopqrstuvwxyz";

        System.out.println(
                "Example 1: " +
                        solution.isAlienSorted(words1, order1)
        );


        String[] words2 = {"word", "world", "row"};
        String order2 = "worldabcefghijkmnpqstuvxyz";

        System.out.println(
                "Example 2: " +
                        solution.isAlienSorted(words2, order2)
        );


        String[] words3 = {"apple", "app"};
        String order3 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(
                "Example 3: " +
                        solution.isAlienSorted(words3, order3)
        );
    }
}