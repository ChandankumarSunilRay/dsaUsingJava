package string.easy;

public class findtheIndexoftheFirstOccurrenceinaString132 {

    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String haystack1 = "sadbutsad";
        String needle1 = "sad";

        System.out.println("Input: haystack = \"" + haystack1 + "\", needle = \"" + needle1 + "\"");
        System.out.println("Output: " + strStr(haystack1, needle1));

        System.out.println();

        String haystack2 = "leetcode";
        String needle2 = "leeto";

        System.out.println("Input: haystack = \"" + haystack2 + "\", needle = \"" + needle2 + "\"");
        System.out.println("Output: " + strStr(haystack2, needle2));
    }
}