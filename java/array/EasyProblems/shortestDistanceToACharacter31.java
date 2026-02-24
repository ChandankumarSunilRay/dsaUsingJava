package EasyProblems;

import java.util.Arrays;

public class shortestDistanceToACharacter31 {

    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];

        int lastSeen = -10000;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                lastSeen = i;
            }
            answer[i] = i - lastSeen;
        }

        lastSeen = 10000;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                lastSeen = i;
            }
            answer[i] = Math.min(answer[i], lastSeen - i);
        }

        return answer;
    }


    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';

        int[] result = shortestToChar(s, c);

        System.out.println("Input string: " + s);
        System.out.println("Target character: " + c);
        System.out.println("Output distances: " + Arrays.toString(result));
    }
}
