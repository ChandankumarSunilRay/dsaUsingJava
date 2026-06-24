package string.easy;

import java.util.Scanner;

public class romantoInteger133 {

    public int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = getValue(s.charAt(i));

            if (i < s.length() - 1 &&
                    current < getValue(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roman Numeral: ");
        String roman = sc.nextLine().toUpperCase();

        romantoInteger133 converter = new romantoInteger133();
        int result = converter.romanToInt(roman);

        System.out.println("Integer Value: " + result);

        sc.close();
    }
}