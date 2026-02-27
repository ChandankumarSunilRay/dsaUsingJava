package string.easy;

public class isomorphicStrings6 {
    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] mapST = new int[256];
        int[] mapTS = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapST[c1] != mapTS[c2]) {
                return false;
            }

            mapST[c1] = i + 1;
            mapTS[c2] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "egg";
        String t1 = "add";

        String s2 = "foo";
        String t2 = "bar";

        String s3 = "paper";
        String t3 = "title";

        System.out.println(s1 + " & " + t1 + " → " + isIsomorphic(s1, t1));
        System.out.println(s2 + " & " + t2 + " → " + isIsomorphic(s2, t2));
        System.out.println(s3 + " & " + t3 + " → " + isIsomorphic(s3, t3));
    }
}