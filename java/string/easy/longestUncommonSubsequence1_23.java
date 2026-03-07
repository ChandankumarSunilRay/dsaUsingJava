package string.easy;
import java.util.Scanner;


public class longestUncommonSubsequence1_23 {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String a = sc.nextLine();

        System.out.print("Enter second string: ");
        String b = sc.nextLine();

        longestUncommonSubsequence1_23 obj = new longestUncommonSubsequence1_23();

        int result = obj.findLUSlength(a, b);

        System.out.println("Longest Uncommon Subsequence Length: " + result);

        sc.close();
    }
}