package string.easy;

import java.util.*;

public class positionsofLargeGroups77 {

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            int j = i;

            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            if (j - i >= 3) {
                result.add(Arrays.asList(i, j - 1));
            }

            i = j;
        }

        return result;
    }

    public static void main(String[] args) {
        String s1 = "abbxxxxzzy";
        String s2 = "abc";
        String s3 = "abcdddeeeeaabbbcd";

        System.out.println("Input: " + s1);
        System.out.println("Output: " + largeGroupPositions(s1));

        System.out.println("\nInput: " + s2);
        System.out.println("Output: " + largeGroupPositions(s2));

        System.out.println("\nInput: " + s3);
        System.out.println("Output: " + largeGroupPositions(s3));
    }
}