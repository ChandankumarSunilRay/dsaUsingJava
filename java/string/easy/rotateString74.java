package string.easy;

import java.util.Scanner;

public class rotateString74 {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter goal string: ");
        String goal = sc.nextLine();

        rotateString74 obj = new rotateString74();
        boolean result = obj.rotateString(s, goal);

        System.out.println("Can s be rotated to goal? " + result);

        sc.close();
    }
}