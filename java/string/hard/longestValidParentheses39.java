package string.hard;

import java.util.Stack;

public class longestValidParentheses39 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        longestValidParentheses39 obj = new longestValidParentheses39();

        String s = ")()())";
        int result = obj.longestValidParentheses(s);

        System.out.println("Input: " + s);
        System.out.println("Longest Valid Parentheses Length: " + result);
    }
}