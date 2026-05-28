package string.easy;

public class integertoEnglishWords106 {

    static String[] below20 = {
            "", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    static String[] tens = {
            "", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        return helper(num).trim();
    }

    public String helper(int num) {

        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return below20[num] + " ";
        }

        else if (num < 100) {

            if (num % 10 == 0) {
                return tens[num / 10] + " ";
            }

            return tens[num / 10] + " " +
                    helper(num % 10);
        }

        else if (num < 1000) {
            return helper(num / 100).trim() +
                    " Hundred " +
                    helper(num % 100);
        }

        else if (num < 1_000_000) {
            return helper(num / 1000).trim() +
                    " Thousand " +
                    helper(num % 1000);
        }

        else if (num < 1_000_000_000) {
            return helper(num / 1_000_000).trim() +
                    " Million " +
                    helper(num % 1_000_000);
        }

        else {
            return helper(num / 1_000_000_000).trim() +
                    " Billion " +
                    helper(num % 1_000_000_000);
        }
    }

    public static void main(String[] args) {

        integertoEnglishWords106 obj = new integertoEnglishWords106();

        int num1 = 123;
        int num2 = 12345;
        int num3 = 1234567;
        int num4 = 50868;
        int num5 = 90;

        System.out.println(num1 + " -> " + obj.numberToWords(num1));
        System.out.println(num2 + " -> " + obj.numberToWords(num2));
        System.out.println(num3 + " -> " + obj.numberToWords(num3));
        System.out.println(num4 + " -> " + obj.numberToWords(num4));
        System.out.println(num5 + " -> " + obj.numberToWords(num5));
    }
}