package string.hard;

import java.util.*;

public class parseLispExpression60 {

    public int evaluate(String expression) {
        return helper(expression, new HashMap<>());
    }

    private int helper(String expr, Map<String, Integer> map) {
        if (expr.charAt(0) != '(') {
            if (Character.isDigit(expr.charAt(0)) || expr.charAt(0) == '-') {
                return Integer.parseInt(expr);
            }
            return map.get(expr);
        }

        String inner = expr.substring(1, expr.length() - 1);
        List<String> tokens = parse(inner);

        String op = tokens.get(0);

        if (op.equals("add")) {
            return helper(tokens.get(1), new HashMap<>(map)) +
                    helper(tokens.get(2), new HashMap<>(map));
        }

        if (op.equals("mult")) {
            return helper(tokens.get(1), new HashMap<>(map)) *
                    helper(tokens.get(2), new HashMap<>(map));
        }

        Map<String, Integer> newMap = new HashMap<>(map);

        for (int i = 1; i < tokens.size() - 1; i += 2) {
            String var = tokens.get(i);
            String valExpr = tokens.get(i + 1);

            int val = helper(valExpr, newMap);
            newMap.put(var, val);
        }

        return helper(tokens.get(tokens.size() - 1), newMap);
    }

    private List<String> parse(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }

            if (s.charAt(i) == '(') {
                int start = i;
                int count = 0;

                while (i < s.length()) {
                    if (s.charAt(i) == '(') count++;
                    if (s.charAt(i) == ')') count--;
                    i++;
                    if (count == 0) break;
                }

                res.add(s.substring(start, i));
            } else {
                int start = i;
                while (i < s.length() && s.charAt(i) != ' ') i++;
                res.add(s.substring(start, i));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        parseLispExpression60 obj = new parseLispExpression60();

        String exp1 = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
        String exp2 = "(let x 3 x 2 x)";
        String exp3 = "(let x 1 y 2 x (add x y) (add x y))";

        System.out.println("Output 1: " + obj.evaluate(exp1));
        System.out.println("Output 2: " + obj.evaluate(exp2));
        System.out.println("Output 3: " + obj.evaluate(exp3));
    }
}