package string.easy;

import java.util.Scanner;

public class generateaStringWithCharactersThatHaveOddCounts138 {

    public String generateTheString(int n) {
        StringBuilder result = new StringBuilder();

        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                result.append('a');
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                result.append('a');
            }
            result.append('b');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        generateaStringWithCharactersThatHaveOddCounts138 solution =
                new generateaStringWithCharactersThatHaveOddCounts138();

        String answer = solution.generateTheString(n);

        System.out.println("Generated String: " + answer);

        scanner.close();
    }
}