package string.easy;

import java.util.Scanner;

public class repeatedSubstringPattern13 {

    public static boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String trimmed = doubled.substring(1, doubled.length() - 1);
        return trimmed.contains(s);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        boolean result = repeatedSubstringPattern(input);

        System.out.println("Is repeated substring pattern? " + result);

        sc.close();
    }
}