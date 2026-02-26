package string.easy;

public class slowestKey5 {

    public static char slowestKey(int[] releaseTimes, String keysPressed) {

        int maxDuration = releaseTimes[0];
        char result = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char currentChar = keysPressed.charAt(i);

            if (duration > maxDuration) {
                maxDuration = duration;
                result = currentChar;
            }
            else if (duration == maxDuration && currentChar > result) {
                result = currentChar;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] releaseTimes1 = {9, 29, 49, 50};
        String keysPressed1 = "cbcd";

        char result1 = slowestKey(releaseTimes1, keysPressed1);
        System.out.println("Output Example 1: " + result1);


        int[] releaseTimes2 = {12, 23, 36, 46, 62};
        String keysPressed2 = "spuda";

        char result2 = slowestKey(releaseTimes2, keysPressed2);
        System.out.println("Output Example 2: " + result2);
    }
}