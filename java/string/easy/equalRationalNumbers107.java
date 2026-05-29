package string.easy;

public class equalRationalNumbers107 {

    public boolean isRationalEqual(String s, String t) {
        return Math.abs(value(s) - value(t)) < 1e-12;
    }

    private double value(String s) {

        int l = s.indexOf('(');

        if (l == -1) {
            return Double.parseDouble(s);
        }

        String nonRepeat = s.substring(0, l);
        String repeat = s.substring(l + 1, s.length() - 1);

        StringBuilder sb = new StringBuilder(nonRepeat);

        for (int i = 0; i < 20; i++) {
            sb.append(repeat);
        }

        return Double.parseDouble(sb.toString());
    }

    public static void main(String[] args) {

        equalRationalNumbers107 obj = new equalRationalNumbers107();

        String s1 = "0.(52)";
        String t1 = "0.5(25)";

        String s2 = "0.1666(6)";
        String t2 = "0.166(66)";

        String s3 = "0.9(9)";
        String t3 = "1.";

        System.out.println(obj.isRationalEqual(s1, t1));
        System.out.println(obj.isRationalEqual(s2, t2));
        System.out.println(obj.isRationalEqual(s3, t3));
    }
}