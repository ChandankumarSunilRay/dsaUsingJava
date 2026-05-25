package string.easy;

import java.util.Scanner;

public class goalParserInterpretation103 {

    public String interpret(String command) {

        String result = "";

        for (int i = 0; i < command.length(); i++) {

            if (command.charAt(i) == 'G') {
                result += "G";
            }

            else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                result += "o";
                i++;
            }

            else {
                result += "al";
                i += 3;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter command: ");
        String command = sc.next();

        goalParserInterpretation103 obj = new goalParserInterpretation103();

        System.out.println("Output: " + obj.interpret(command));

        sc.close();
    }
}