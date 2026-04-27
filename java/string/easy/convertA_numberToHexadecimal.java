package string.easy;

import java.util.Scanner;

public class convertA_numberToHexadecimal {

    public static String toHex(int num) {
        if (num == 0) return "0";

        char[] map = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int digit = num & 15;
            sb.append(map[digit]);
            num >>>= 4;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        String result = toHex(num);
        System.out.println("Hexadecimal: " + result);

        sc.close();
    }
}