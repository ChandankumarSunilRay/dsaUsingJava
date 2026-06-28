package string.easy;
public class findWordsThatCanBeFormedbyCharacters136 {

    public int countCharacters(String[] words, String chars) {
        int[] available = new int[26];
        for (char ch : chars.toCharArray()) {
            available[ch - 'a']++;
        }
        int totalLength = 0;

        for (String word : words) {

            int[] current = new int[26];
            boolean canForm = true;

            for (char ch : word.toCharArray()) {
                current[ch - 'a']++;
                if (current[ch - 'a'] > available[ch - 'a']) {
                    canForm = false;
                    break;
                }
            }
            if (canForm) {
                totalLength += word.length();
            }
        }
        return totalLength;
    }
}
class Main {
    public static void main(String[] args) {

        findWordsThatCanBeFormedbyCharacters136 obj =
                new findWordsThatCanBeFormedbyCharacters136();

        String[] words1 = {"cat", "bt", "hat", "tree"};
        String chars1 = "atach";

        System.out.println("Example 1 Output: " +
                obj.countCharacters(words1, chars1));

        String[] words2 = {"hello", "world", "leetcode"};
        String chars2 = "welldonehoneyr";

        System.out.println("Example 2 Output: " +
                obj.countCharacters(words2, chars2));
    }
}