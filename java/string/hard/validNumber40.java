package string.hard;

public class validNumber40 {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;
        boolean digitAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
                digitAfterE = true;
            }
            else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            }
            else if (c == '.') {
                if (seenDot || seenE)
                    return false;
                seenDot = true;
            }
            else if (c == 'e' || c == 'E') {
                if (seenE || !seenDigit)
                    return false;
                seenE = true;
                digitAfterE = false;
            }
            else {
                return false;
            }
        }
        return seenDigit && digitAfterE;
    }

    public static void main(String[] args) {
        validNumber40 obj = new validNumber40();
        String[] tests = {
                "2",
                "0089",
                "-0.1",
                "+3.14",
                "4.",
                "-.9",
                "2e10",
                "-90E3",
                "3e+7",
                "+6e-1",
                "53.5e93",
                "-123.456e789",
                "abc",
                "1a",
                "1e",
                "e3",
                "99e2.5",
                "--6",
                "-+3",
                "95a54e53"
        };
        for (String s : tests) {
            System.out.println("Input: " + s + " -> " + obj.isNumber(s));
        }
    }
}