package string.easy;

public class backspaceStringCompare79 {

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {

            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            char c1 = (i >= 0) ? s.charAt(i) : '\0';
            char c2 = (j >= 0) ? t.charAt(j) : '\0';

            if (c1 != c2) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        backspaceStringCompare79 obj = new backspaceStringCompare79();

        String s1 = "ab#c";
        String t1 = "ad#c";
        System.out.println(obj.backspaceCompare(s1, t1));

        String s2 = "ab##";
        String t2 = "c#d#";
        System.out.println(obj.backspaceCompare(s2, t2));

        String s3 = "a#c";
        String t3 = "b";
        System.out.println(obj.backspaceCompare(s3, t3));


        String s4 = "a##c";
        String t4 = "#a#c";
        System.out.println(obj.backspaceCompare(s4, t4));
    }
}