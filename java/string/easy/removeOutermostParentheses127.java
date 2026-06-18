package string.easy;

public class removeOutermostParentheses127 {

    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                if (depth > 0) {
                    result.append(ch);
                }
                depth++;
            } else {
                depth--;

                if (depth > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        removeOutermostParentheses127 solution =
                new removeOutermostParentheses127();

        String s1 = "(()())(())";
        String s2 = "(()())(())(()(()))";
        String s3 = "()()";

        System.out.println("Input : " + s1);
        System.out.println("Output: " +
                solution.removeOuterParentheses(s1));

        System.out.println();

        System.out.println("Input : " + s2);
        System.out.println("Output: " +
                solution.removeOuterParentheses(s2));

        System.out.println();

        System.out.println("Input : " + s3);
        System.out.println("Output: " +
                solution.removeOuterParentheses(s3));
    }
}