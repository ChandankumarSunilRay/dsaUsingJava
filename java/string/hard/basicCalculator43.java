package string.hard;

import java.util.Stack;

public class basicCalculator43 {

    public int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }
            else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            }
            else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            }
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }
            else if (c == ')') {
                result += sign * number;
                number = 0;

                result *= stack.pop();
                result += stack.pop();
            }
        }
        result += sign * number;
        return result;
    }

    public static void main(String[] args) {
        basicCalculator43 solver = new basicCalculator43();

        String test1 = "1 + 1";
        String test2 = " 2-1 + 2 ";
        String test3 = "(1+(4+5+2)-3)+(6+8)";

        System.out.println("Test 1: " + solver.calculate(test1));
        System.out.println("Test 2: " + solver.calculate(test2));
        System.out.println("Test 3: " + solver.calculate(test3));
    }
}