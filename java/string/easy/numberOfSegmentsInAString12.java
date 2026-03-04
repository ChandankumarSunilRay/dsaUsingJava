package string.easy;

public class numberOfSegmentsInAString12 {

    public static int countSegments(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String s1 = "Hello, my name is John";
        String s2 = "Hello";
        String s3 = "   Leading and trailing spaces   ";
        String s4 = "";

        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Segments: " + countSegments(s1));

        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Segments: " + countSegments(s2));

        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Segments: " + countSegments(s3));

        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Segments: " + countSegments(s4));
    }
}