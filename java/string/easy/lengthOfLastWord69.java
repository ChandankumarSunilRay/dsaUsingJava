package string.easy;

public class lengthOfLastWord69 {

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }

    public static void main(String[] args) {
        lengthOfLastWord69 obj = new lengthOfLastWord69();

        String s1 = "Hello World";
        String s2 = "   fly me   to   the moon  ";
        String s3 = "luffy is still joyboy";

        System.out.println("Output 1: " + obj.lengthOfLastWord(s1));
        System.out.println("Output 2: " + obj.lengthOfLastWord(s2));
        System.out.println("Output 3: " + obj.lengthOfLastWord(s3));
    }
}