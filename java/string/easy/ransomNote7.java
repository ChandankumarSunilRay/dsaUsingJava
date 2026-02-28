package string.easy;

public class ransomNote7 {

    public static boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return false;
            }
            count[c - 'a']--;
        }

        return true;
    }

    public static void main(String[] args) {

        String ransom1 = "a";
        String magazine1 = "b";

        String ransom2 = "aa";
        String magazine2 = "ab";

        String ransom3 = "aa";
        String magazine3 = "aab";

        System.out.println("Example 1: " + canConstruct(ransom1, magazine1));
        System.out.println("Example 2: " + canConstruct(ransom2, magazine2));
        System.out.println("Example 3: " + canConstruct(ransom3, magazine3));
    }
}