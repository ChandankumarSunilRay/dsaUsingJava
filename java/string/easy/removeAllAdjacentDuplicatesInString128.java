package string.easy;

import java.util.Scanner;

public class removeAllAdjacentDuplicatesInString128 {

    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int n = stack.length();

            if (n > 0 && stack.charAt(n - 1) == ch) {
                stack.setLength(n - 1); // pop
            } else {
                stack.append(ch); // push
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        removeAllAdjacentDuplicatesInString128 obj =
                new removeAllAdjacentDuplicatesInString128();

        System.out.println("Result: " + obj.removeDuplicates(s));

        sc.close();
    }
}