package string.easy;
import java.util.Scanner;
public class validNumber113 {

    public static boolean isNumber(String s) {
        s = s.trim();

        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                numSeen = true;
            }
            else if (ch == '.') {

                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            }
            else if (ch == 'e' || ch == 'E') {

                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;


                numSeen = false;
            }
            else if (ch == '+' || ch == '-') {

                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return numSeen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Is Valid Number? " + isNumber(input));

        sc.close();
    }
}