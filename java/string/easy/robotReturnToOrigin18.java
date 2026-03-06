package string.easy;

import java.util.Scanner;

public class robotReturnToOrigin18 {

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            } else if (move == 'L') {
                x--;
            } else if (move == 'R') {
                x++;
            }
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter moves string (U,D,L,R): ");
        String moves = sc.nextLine();

        robotReturnToOrigin18 obj = new robotReturnToOrigin18();
        boolean result = obj.judgeCircle(moves);

        System.out.println("Robot returns to origin: " + result);

        sc.close();
    }
}






