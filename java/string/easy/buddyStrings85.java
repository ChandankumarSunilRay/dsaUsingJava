package string.easy;

public class buddyStrings85 {

    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {


            int[] freq = new int[26];

            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;

                if (freq[ch - 'a'] > 1) {
                    return true;
                }
            }

            return false;
        }

        int first = -1;
        int second = -1;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != goal.charAt(i)) {

                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {

                    return false;
                }
            }
        }
        return second != -1 &&
                s.charAt(first) == goal.charAt(second) &&
                s.charAt(second) == goal.charAt(first);
    }

    public static void main(String[] args) {

        buddyStrings85 obj = new buddyStrings85();

        System.out.println(obj.buddyStrings("ab", "ba"));
        System.out.println(obj.buddyStrings("ab", "ab"));
        System.out.println(obj.buddyStrings("aa", "aa"));
        System.out.println(obj.buddyStrings("abcd", "badc"));
    }
}