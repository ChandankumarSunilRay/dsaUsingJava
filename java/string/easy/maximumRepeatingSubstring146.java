package string.easy;

public class maximumRepeatingSubstring146 {

    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String repeated = word;

        while (sequence.contains(repeated)) {
            count++;
            repeated += word;
        }

        return count;
    }
    public static void main(String[] args) {
        maximumRepeatingSubstring146 solution = new maximumRepeatingSubstring146();

        String sequence1 = "ababc";
        String word1 = "ab";
        System.out.println("Input: sequence = " + sequence1 + ", word = " + word1);
        System.out.println("Output: " + solution.maxRepeating(sequence1, word1));
        System.out.println();

        String sequence2 = "ababc";
        String word2 = "ba";
        System.out.println("Input: sequence = " + sequence2 + ", word = " + word2);
        System.out.println("Output: " + solution.maxRepeating(sequence2, word2));
        System.out.println();

        String sequence3 = "ababc";
        String word3 = "ac";
        System.out.println("Input: sequence = " + sequence3 + ", word = " + word3);
        System.out.println("Output: " + solution.maxRepeating(sequence3, word3));
    }
}