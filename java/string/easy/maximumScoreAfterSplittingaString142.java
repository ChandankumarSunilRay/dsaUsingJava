package string.easy;

public class maximumScoreAfterSplittingaString142 {

    public static int maxScore(String s) {
        int rightOnes = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                rightOnes++;
            }
        }

        int leftZeros = 0;
        int maxScore = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }

            maxScore = Math.max(maxScore, leftZeros + rightOnes);
        }

        return maxScore;
    }

    public static void main(String[] args) {

        String s1 = "011101";
        System.out.println("Input: " + s1);
        System.out.println("Maximum Score: " + maxScore(s1));

        String s2 = "00111";
        System.out.println("\nInput: " + s2);
        System.out.println("Maximum Score: " + maxScore(s2));

        String s3 = "1111";
        System.out.println("\nInput: " + s3);
        System.out.println("Maximum Score: " + maxScore(s3));

        String s4 = "01001";
        System.out.println("\nInput: " + s4);
        System.out.println("Maximum Score: " + maxScore(s4));
    }
}