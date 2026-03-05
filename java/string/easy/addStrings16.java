package string.easy;

public class addStrings16 {

    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {

            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;

            result.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {

        addStrings16 obj = new addStrings16();

        String num1 = "456";
        String num2 = "77";

        String result = obj.addStrings(num1, num2);

        System.out.println("Num1: " + num1);
        System.out.println("Num2: " + num2);
        System.out.println("Sum: " + result);
    }
}