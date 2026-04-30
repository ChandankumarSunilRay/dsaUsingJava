package string.easy;

import java.util.Scanner;

public class romantoInteger78 {

    public int romanToInt(String s) {
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = value(s.charAt(i));

            if (i < s.length() - 1 && curr < value(s.charAt(i + 1))) {
                total -= curr;
            } else {
                total += curr;
            }
        }

        return total;
    }

    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Roman numeral: ");
        String input = scanner.nextLine();

        romantoInteger78 converter = new romantoInteger78();
        int result = converter.romanToInt(input);

        System.out.println("Integer value: " + result);

        scanner.close();
    }
}