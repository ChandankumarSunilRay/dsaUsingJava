package string.hard;

public class longestHappyPrefix58 {

    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return s.substring(0, lps[n - 1]);
    }

    public static void main(String[] args) {
        longestHappyPrefix58 obj = new longestHappyPrefix58();

        String input1 = "level";
        String input2 = "ababab";
        String input3 = "a";

        System.out.println("Input: " + input1);
        System.out.println("Output: " + obj.longestPrefix(input1));

        System.out.println("Input: " + input2);
        System.out.println("Output: " + obj.longestPrefix(input2));

        System.out.println("Input: " + input3);
        System.out.println("Output: " + obj.longestPrefix(input3));
    }
}


