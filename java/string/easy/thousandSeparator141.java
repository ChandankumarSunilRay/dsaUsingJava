package string.easy;

public class thousandSeparator141 {

    public String thousandSeparator(int n) {
        String s = Integer.toString(n);
        StringBuilder result = new StringBuilder();

        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
            count++;

            if (count == 3 && i != 0) {
                result.append('.');
                count = 0;
            }
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        thousandSeparator141 obj = new thousandSeparator141();

        int[] testCases = {
                987,
                1234,
                123456789,
                0,
                1000,
                1000000,
                2147483647
        };

        for (int n : testCases) {
            System.out.println("Input : " + n);
            System.out.println("Output: " + obj.thousandSeparator(n));
            System.out.println();
        }
    }
}