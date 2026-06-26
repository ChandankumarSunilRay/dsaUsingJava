package string.easy;

public class reformatTheString135 {

    public String reformat(String s) {
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.append(ch);
            } else {
                letters.append(ch);
            }
        }

        if (Math.abs(letters.length() - digits.length()) > 1) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        int i = 0, j = 0;

        boolean letterTurn = letters.length() >= digits.length();

        while (i < letters.length() || j < digits.length()) {

            if (letterTurn) {
                if (i < letters.length()) {
                    result.append(letters.charAt(i++));
                }
            } else {
                if (j < digits.length()) {
                    result.append(digits.charAt(j++));
                }
            }

            letterTurn = !letterTurn;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        reformatTheString135 solution = new reformatTheString135();

        String[] testCases = {
                "a0b1c2",
                "leetcode",
                "1229857369",
                "covid2019",
                "ab123",
                "1a",
                "a",
                "9"
        };

        for (String test : testCases) {
            System.out.println("Input : " + test);
            System.out.println("Output: " + solution.reformat(test));
            System.out.println("---------------------------");
        }
    }
}







