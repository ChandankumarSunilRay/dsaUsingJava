package string.easy;

public class makeTheStringGreat143 {

    public String makeGood(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = stack.length();

            if (len > 0 && Math.abs(stack.charAt(len - 1) - ch) == 32) {
                stack.deleteCharAt(len - 1);
            } else {
                stack.append(ch);
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        makeTheStringGreat143 solution = new makeTheStringGreat143();

        String s1 = "leEeetcode";
        String s2 = "abBAcC";
        String s3 = "s";
        String s4 = "Pp";
        String s5 = "mMAbBcC";

        System.out.println("Input : " + s1);
        System.out.println("Output: " + solution.makeGood(s1));

        System.out.println();

        System.out.println("Input : " + s2);
        System.out.println("Output: " + solution.makeGood(s2));

        System.out.println();

        System.out.println("Input : " + s3);
        System.out.println("Output: " + solution.makeGood(s3));

        System.out.println();

        System.out.println("Input : " + s4);
        System.out.println("Output: " + solution.makeGood(s4));

        System.out.println();

        System.out.println("Input : " + s5);
        System.out.println("Output: " + solution.makeGood(s5));
    }
}