package string.medium;

import java.util.ArrayList;
import java.util.List;

public class generateParentheses33 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int n) {


        if (current.length() == n * 2) {
            result.add(current);
            return;
        }

        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {

        generateParentheses33 obj = new generateParentheses33();

        int n = 3;

        List<String> result = obj.generateParenthesis(n);

        System.out.println("Valid Parentheses combinations:");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
