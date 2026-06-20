package string.easy;

import java.util.Stack;

public class parsingABooleanExpression129 {

    public boolean parseBoolExpr(String expression) {

        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (ch == ',') {
                continue;
            }

            if (ch != ')') {
                stack.push(ch);
                continue;
            }

            int trueCount = 0;
            int falseCount = 0;

            while (stack.peek() != '(') {
                char value = stack.pop();

                if (value == 't') {
                    trueCount++;
                } else if (value == 'f') {
                    falseCount++;
                }
            }

            stack.pop();

            char operator = stack.pop();

            char result;

            switch (operator) {
                case '!':
                    result = (falseCount == 1) ? 't' : 'f';
                    break;

                case '&':
                    result = (falseCount > 0) ? 'f' : 't';
                    break;

                case '|':
                    result = (trueCount > 0) ? 't' : 'f';
                    break;

                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }

            stack.push(result);
        }

        return stack.pop() == 't';
    }

    public static void main(String[] args) {

        parsingABooleanExpression129 solution =
                new parsingABooleanExpression129();

        String exp1 = "&(|(f))";
        String exp2 = "|(f,f,f,t)";
        String exp3 = "!(&(f,t))";

        System.out.println("Expression: " + exp1);
        System.out.println("Result: " + solution.parseBoolExpr(exp1));

        System.out.println();

        System.out.println("Expression: " + exp2);
        System.out.println("Result: " + solution.parseBoolExpr(exp2));

        System.out.println();

        System.out.println("Expression: " + exp3);
        System.out.println("Result: " + solution.parseBoolExpr(exp3));
    }
}