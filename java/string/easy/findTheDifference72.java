package string.easy;

import java.util.Scanner;

public class findTheDifference72 {

    public char findTheDifference(String s, String t) {
        char result = 0;

        for (char c : s.toCharArray()) {
            result ^= c;
        }

        for (char c : t.toCharArray()) {
            result ^= c;
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        findTheDifference72 obj = new findTheDifference72();

        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter string t: ");
        String t = sc.nextLine();

        char result = obj.findTheDifference(s, t);
        System.out.println("Extra character: " + result);

        sc.close();
    }
}