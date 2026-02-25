package string.easy;

public class shuffleString4 {

    public static String restoreString(String s, int[] indices) {
        char[] result = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }

        return new String(result);
    }

    public static void main(String[] args) {

        String s1 = "codeleet";
        int[] indices1 = {4, 5, 6, 7, 0, 2, 1, 3};

        String output1 = restoreString(s1, indices1);
        System.out.println("Input: " + s1);
        System.out.println("Output: " + output1);

        System.out.println("------------------");

        String s2 = "abc";
        int[] indices2 = {0, 1, 2};

        String output2 = restoreString(s2, indices2);
        System.out.println("Input: " + s2);
        System.out.println("Output: " + output2);
    }
}