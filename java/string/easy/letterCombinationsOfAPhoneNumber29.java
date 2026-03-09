package string.easy;

import java.util.*;

public class letterCombinationsOfAPhoneNumber29 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] map = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), result, map);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result, String[] map) {

        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(digits, index + 1, current, result, map);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        letterCombinationsOfAPhoneNumber29 obj = new letterCombinationsOfAPhoneNumber29();

        System.out.print("Enter digits (2-9): ");
        String digits = scanner.nextLine();

        List<String> combinations = obj.letterCombinations(digits);

        System.out.println("Letter Combinations:");
        System.out.println(combinations);

        scanner.close();
    }
}