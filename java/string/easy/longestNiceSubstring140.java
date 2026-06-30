package string.easy;

public class longestNiceSubstring140 {

    public String longestNiceSubstring(String s) {
        int n = s.length();
        String ans = "";

        for (int i = 0; i < n; i++) {

            boolean[] lower = new boolean[26];
            boolean[] upper = new boolean[26];

            for (int j = i; j < n; j++) {

                char ch = s.charAt(j);

                if (Character.isLowerCase(ch)) {
                    lower[ch - 'a'] = true;
                } else {
                    upper[ch - 'A'] = true;
                }

                if (isNice(lower, upper)) {
                    if (j - i + 1 > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }

        return ans;
    }

    private boolean isNice(boolean[] lower, boolean[] upper) {

        for (int i = 0; i < 26; i++) {
            if ((lower[i] || upper[i]) && lower[i] != upper[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        longestNiceSubstring140 obj = new longestNiceSubstring140();

        String s1 = "YazaAay";
        String s2 = "Bb";
        String s3 = "c";
        String s4 = "dDzeE";

        System.out.println("Input: " + s1);
        System.out.println("Output: " + obj.longestNiceSubstring(s1));

        System.out.println();

        System.out.println("Input: " + s2);
        System.out.println("Output: " + obj.longestNiceSubstring(s2));

        System.out.println();

        System.out.println("Input: " + s3);
        System.out.println("Output: " + obj.longestNiceSubstring(s3));

        System.out.println();

        System.out.println("Input: " + s4);
        System.out.println("Output: " + obj.longestNiceSubstring(s4));
    }
}