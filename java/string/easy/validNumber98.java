package string.easy;
public class validNumber98 {
    public boolean isNumber(String s) {

        boolean num = false;
        boolean dot = false;
        boolean exp = false;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);


            if (Character.isDigit(c)) {
                num = true;
            }


            else if (c == '+' || c == '-') {


                if (i > 0 &&
                        s.charAt(i - 1) != 'e' &&
                        s.charAt(i - 1) != 'E') {

                    return false;
                }
            }

            else if (c == '.') {

                // only one dot and before exponent
                if (dot || exp) {
                    return false;
                }

                dot = true;
            }

            else if (c == 'e' || c == 'E') {

                if (exp || !num) {
                    return false;
                }

                exp = true;

                num = false;
            }

            else {
                return false;
            }
        }

        return num;
    }

    public static void main(String[] args) {

        validNumber98 obj = new validNumber98();

        String[] testCases = {
                "0",
                "e",
                ".",
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

        for (String s : testCases) {
            System.out.println(s + " -> " + obj.isNumber(s));
        }
    }
}