package string.easy;

public class greatestCommonDivisiorOfStrings96 {

    public String gcdOfStrings(String str1, String str2) {

        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLength = gcd(str1.length(), str2.length());

        return str1.substring(0, gcdLength);
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {

        greatestCommonDivisiorOfStrings96 obj =
                new greatestCommonDivisiorOfStrings96();
        String str1 = "ABCABC";
        String str2 = "ABC";

        System.out.println("Input:");
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        String result = obj.gcdOfStrings(str1, str2);

        System.out.println("Output:");
        System.out.println(result);

        System.out.println();

        System.out.println(
                obj.gcdOfStrings("ABABAB", "ABAB")
        );

        System.out.println(
                obj.gcdOfStrings("LEET", "CODE")
        );

        System.out.println(
                obj.gcdOfStrings("AAAAAB", "AAA")
        );
    }
}




