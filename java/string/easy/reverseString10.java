package string.easy;

import java.util.Arrays;
import java.util.Scanner;

public class reverseString10 {

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char[] charArray = input.toCharArray();

        reverseString(charArray);

        System.out.println("Reversed string: " + Arrays.toString(charArray));

        System.out.println("Reversed (as string): " + new String(charArray));

        scanner.close();
    }
}






