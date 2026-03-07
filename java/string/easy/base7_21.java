package string.easy;

public class base7_21 {

    public static String convertToBase7(int num) {

        if (num == 0) {
            return "0";
        }
        boolean isNegative = num < 0;
        num = Math.abs(num);

        StringBuilder result = new StringBuilder();

        while (num > 0) {
            int remainder = num % 7;
            result.append(remainder);
            num = num / 7;
        }
        if (isNegative) {
            result.append("-");
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {

        int num1 = 100;
        int num2 = -7;

        System.out.println("Base 7 of " + num1 + " = " + convertToBase7(num1));
        System.out.println("Base 7 of " + num2 + " = " + convertToBase7(num2));

        int num3 = 49;
        System.out.println("Base 7 of " + num3 + " = " + convertToBase7(num3));
    }
}