package string.easy;

import java.util.Scanner;

public class reverseVowelsOfAstring8 {

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            while (left < right && !isVowel(arr[left])) {
                left++;
            }


            while (left < right && !isVowel(arr[right])) {
                right--;
            }

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = reverseVowels(input);

        System.out.println("Output: " + result);

        sc.close();
    }
}