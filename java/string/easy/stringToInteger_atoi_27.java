package string.easy;

public class stringToInteger_atoi_27 {

    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();

        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        int result = 0;

        // 3. Convert digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. Overflow check
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }

    // Main method for manual execution
    public static void main(String[] args) {

        stringToInteger_atoi_27 obj = new stringToInteger_atoi_27();

        String[] tests = {
                "42",
                "   -042",
                "1337c0d3",
                "0-1",
                "words and 987",
                "91283472332"
        };

        for (String s : tests) {
            int result = obj.myAtoi(s);
            System.out.println("Input: \"" + s + "\" -> Output: " + result);
        }
    }
}