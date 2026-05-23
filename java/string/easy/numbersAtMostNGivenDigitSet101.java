package string.easy;

public class numbersAtMostNGivenDigitSet101 {

    public int atMostNGivenDigitSet(String[] digits, int n) {

        String s = String.valueOf(n);

        int m = digits.length;
        int len = s.length();

        int ans = 0;

        for (int l = 1; l < len; l++) {
            ans += Math.pow(m, l);
        }

        for (int i = 0; i < len; i++) {

            boolean sameDigitFound = false;

            for (String d : digits) {

                char c = d.charAt(0);

                if (c < s.charAt(i)) {

                    ans += Math.pow(m, len - i - 1);

                } else if (c == s.charAt(i)) {

                    sameDigitFound = true;
                }
            }

            if (!sameDigitFound) {
                return ans;
            }
        }

        return ans + 1;
    }

    public static void main(String[] args) {

        numbersAtMostNGivenDigitSet101 obj =
                new numbersAtMostNGivenDigitSet101();

        String[] digits1 = {"1", "3", "5", "7"};
        int n1 = 100;

        System.out.println(
                "Output 1: " +
                        obj.atMostNGivenDigitSet(digits1, n1)
        );

        String[] digits2 = {"1", "4", "9"};
        int n2 = 1000000000;

        System.out.println(
                "Output 2: " +
                        obj.atMostNGivenDigitSet(digits2, n2)
        );

        String[] digits3 = {"7"};
        int n3 = 8;

        System.out.println(
                "Output 3: " +
                        obj.atMostNGivenDigitSet(digits3, n3)
        );
    }
}