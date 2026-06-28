package string.easy;

import java.util.Scanner;

public class decryptStringfromAlphabettoIntegerMapping137 {

    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = s.length() - 1; i >= 0;) {

            if (s.charAt(i) == '#') {
                int num = Integer.parseInt(s.substring(i - 2, i));
                result.append((char) ('a' + num - 1));
                i -= 3;
            } else {
                int num = s.charAt(i) - '0';
                result.append((char) ('a' + num - 1));
                i--;
            }
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the encrypted string: ");
        String input = scanner.nextLine();

        decryptStringfromAlphabettoIntegerMapping137 obj =
                new decryptStringfromAlphabettoIntegerMapping137();

        String output = obj.freqAlphabets(input);

        System.out.println("Decrypted String: " + output);

        scanner.close();
    }
}