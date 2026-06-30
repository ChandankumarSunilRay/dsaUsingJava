package string.easy;

import java.util.Scanner;
public class splitaStringinBalancedStrings139 {
    public int balancedStringSplit(String s) {
        int balance = 0;
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'R') {
                balance++;
            } else {
                balance--;
            }

            if (balance == 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the balanced string: ");
        String s = sc.nextLine();

        splitaStringinBalancedStrings139 obj = new splitaStringinBalancedStrings139();

        int result = obj.balancedStringSplit(s);
        System.out.println("Maximum Balanced Substrings: " + result);
        sc.close();
    }
}