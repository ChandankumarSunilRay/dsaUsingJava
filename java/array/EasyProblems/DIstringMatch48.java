package EasyProblems;

import java.util.Arrays;
public class DIstringMatch48 {

    public static int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];

        int low = 0;
        int high = n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = low++;
            } else {
                result[i] = high--;
            }
        }

        result[n] = low;

        return result;
    }

    public static void main(String[] args) {
        String s1 = "IDID";
        String s2 = "III";
        String s3 = "DDI";

        System.out.println("Input: " + s1);
        System.out.println("Output: " + Arrays.toString(diStringMatch(s1)));

        System.out.println("Input: " + s2);
        System.out.println("Output: " + Arrays.toString(diStringMatch(s2)));

        System.out.println("Input: " + s3);
        System.out.println("Output: " + Arrays.toString(diStringMatch(s3)));
    }
}
