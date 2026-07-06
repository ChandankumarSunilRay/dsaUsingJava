package string.easy;

public class reformatPhoneNumber145 {

    public String reformatNumber(String number) {
        StringBuilder digits = new StringBuilder();

        for (char ch : number.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.append(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = 0;
        int n = digits.length();

        while (n - i > 4) {
            ans.append(digits.substring(i, i + 3)).append("-");
            i += 3;
        }

        int left = n - i;

        if (left == 4) {
            ans.append(digits.substring(i, i + 2))
                    .append("-")
                    .append(digits.substring(i + 2, i + 4));
        } else {
            ans.append(digits.substring(i));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        reformatPhoneNumber145 solution = new reformatPhoneNumber145();

        String[] testCases = {
                "1-23-45 6",
                "123 4-567",
                "123 4-5678",
                "12",
                "--17-5 229 35-39475 "
        };

        for (String number : testCases) {
            System.out.println("Input : " + number);
            System.out.println("Output: " + solution.reformatNumber(number));
            System.out.println();
        }
    }
}