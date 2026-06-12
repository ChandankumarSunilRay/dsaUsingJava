package string.easy;

import java.util.ArrayList;
import java.util.List;

public class expressionAddOperators121 {

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        if (num == null || num.length() == 0) {
            return result;
        }

        backtrack(num, target, 0, "", 0, 0, result);

        return result;
    }

    private void backtrack(String num,
                           int target,
                           int index,
                           String expression,
                           long currentValue,
                           long previousOperand,
                           List<String> result) {

        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expression);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            if (i > index && num.charAt(index) == '0') {
                break;
            }

            String currentStr = num.substring(index, i + 1);
            long currentNum = Long.parseLong(currentStr);

            if (index == 0) {
                backtrack(
                        num,
                        target,
                        i + 1,
                        currentStr,
                        currentNum,
                        currentNum,
                        result
                );
            } else {

                backtrack(
                        num,
                        target,
                        i + 1,
                        expression + "+" + currentStr,
                        currentValue + currentNum,
                        currentNum,
                        result
                );

                backtrack(
                        num,
                        target,
                        i + 1,
                        expression + "-" + currentStr,
                        currentValue - currentNum,
                        -currentNum,
                        result
                );

                backtrack(
                        num,
                        target,
                        i + 1,
                        expression + "*" + currentStr,
                        currentValue - previousOperand + (previousOperand * currentNum),
                        previousOperand * currentNum,
                        result
                );
            }
        }
    }

    public static void main(String[] args) {

        expressionAddOperators121 solver = new expressionAddOperators121();

        System.out.println("Example 1:");
        System.out.println(
                solver.addOperators("123", 6)
        );

        System.out.println("\nExample 2:");
        System.out.println(
                solver.addOperators("232", 8)
        );

        System.out.println("\nExample 3:");
        System.out.println(
                solver.addOperators("3456237490", 9191)
        );

        System.out.println("\nLeading Zero Test:");
        System.out.println(
                solver.addOperators("105", 5)
        );
    }
}