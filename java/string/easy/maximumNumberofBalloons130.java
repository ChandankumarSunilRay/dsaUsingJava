package string.easy;

public class maximumNumberofBalloons130 {

    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }

        return Math.min(
                Math.min(freq['b' - 'a'], freq['a' - 'a']),
                Math.min(
                        Math.min(freq['l' - 'a'] / 2, freq['o' - 'a'] / 2),
                        freq['n' - 'a']
                )
        );
    }

    public static void main(String[] args) {
        maximumNumberofBalloons130 obj = new maximumNumberofBalloons130();

        String text1 = "nlaebolko";
        String text2 = "loonbalxballpoon";
        String text3 = "leetcode";

        System.out.println("Input: " + text1);
        System.out.println("Output: " + obj.maxNumberOfBalloons(text1)); // 1

        System.out.println("Input: " + text2);
        System.out.println("Output: " + obj.maxNumberOfBalloons(text2)); // 2

        System.out.println("Input: " + text3);
        System.out.println("Output: " + obj.maxNumberOfBalloons(text3)); // 0
    }
}