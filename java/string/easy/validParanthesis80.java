package string.easy;

import java.util.Stack;

public class validParanthesis80 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] testCases = {
                "()",
                "()[]{}",
                "(]",
                "([])",
                "([)]",
                "{[]}"
        };

        for (String test : testCases) {
            System.out.println("Input: " + test + " -> " + isValid(test));
        }
    }
}