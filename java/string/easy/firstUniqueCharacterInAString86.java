package string.easy;

public class firstUniqueCharacterInAString86 {

    public int firstUniqChar(String s) {

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }


        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        firstUniqueCharacterInAString86 obj =
                new firstUniqueCharacterInAString86();

        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println("Input: " + s1);
        System.out.println("Output: " + obj.firstUniqChar(s1));

        System.out.println();

        System.out.println("Input: " + s2);
        System.out.println("Output: " + obj.firstUniqChar(s2));

        System.out.println();

        System.out.println("Input: " + s3);
        System.out.println("Output: " + obj.firstUniqChar(s3));
    }
}