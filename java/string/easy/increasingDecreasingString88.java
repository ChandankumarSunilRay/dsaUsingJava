package string.easy;

public class increasingDecreasingString88 {
    public String sortString(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder result = new StringBuilder();

        while (result.length() < s.length()) {

            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    result.append((char) (i + 'a'));
                    freq[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    result.append((char) (i + 'a'));
                    freq[i]--;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        increasingDecreasingString88 obj = new increasingDecreasingString88();

        String s1 = "aaaabbbbcccc";
        System.out.println("Input  : " + s1);
        System.out.println("Output : " + obj.sortString(s1));

        System.out.println();

        String s2 = "rat";
        System.out.println("Input  : " + s2);
        System.out.println("Output : " + obj.sortString(s2));
    }
}