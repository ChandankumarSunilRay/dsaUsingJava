package string.hard;

import java.util.*;

public class numberOfAtoms59 {

    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        int i = 0, n = formula.length();

        while (i < n) {
            char c = formula.charAt(i);

            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            }
            else if (c == ')') {
                i++;
                int start = i;

                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplier = (start < i) ? Integer.parseInt(formula.substring(start, i)) : 1;

                Map<String, Integer> top = stack.pop();
                Map<String, Integer> current = stack.peek();

                for (String key : top.keySet()) {
                    current.put(key, current.getOrDefault(key, 0) + top.get(key) * multiplier);
                }
            }
            else {
                int start = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String element = formula.substring(start, i);

                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int count = (start < i) ? Integer.parseInt(formula.substring(start, i)) : 1;

                Map<String, Integer> current = stack.peek();
                current.put(element, current.getOrDefault(element, 0) + count);
            }
        }

        Map<String, Integer> result = stack.pop();
        TreeMap<String, Integer> sorted = new TreeMap<>(result);

        StringBuilder sb = new StringBuilder();
        for (String key : sorted.keySet()) {
            sb.append(key);
            if (sorted.get(key) > 1) {
                sb.append(sorted.get(key));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        numberOfAtoms59 obj = new numberOfAtoms59();

        String[] testCases = {
                "H2O",
                "Mg(OH)2",
                "K4(ON(SO3)2)2"
        };

        for (String formula : testCases) {
            String result = obj.countOfAtoms(formula);
            System.out.println("Input: " + formula);
            System.out.println("Output: " + result);
            System.out.println("----------------------");
        }
    }
}

