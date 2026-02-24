package string.easy;

public class numberOfLinesToWriteString3 {

    public int[] numberOfLines(int[] widths, String s) {

        int lines = 1;
        int currentWidth = 0;

        for (char c : s.toCharArray()) {

            int width = widths[c - 'a'];

            if (currentWidth + width > 100) {
                lines++;
                currentWidth = width;
            } else {
                currentWidth += width;
            }
        }

        return new int[]{lines, currentWidth};
    }

    public static void main(String[] args) {

        numberOfLinesToWriteString3 obj = new numberOfLinesToWriteString3();

        int[] widths = {
                10,10,10,10,10,10,10,10,10,10,
                10,10,10,10,10,10,10,10,10,10,
                10,10,10,10,10,10
        };

        String s = "abcdefghijklmnopqrstuvwxyz";

        int[] result = obj.numberOfLines(widths, s);

        System.out.println("Total Lines: " + result[0]);
        System.out.println("Last Line Width: " + result[1]);
    }
}