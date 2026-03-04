package string.easy;

public class licenseKeyFormatting14 {

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '-') continue;

            if (count == k) {
                sb.append('-');
                count = 0;
            }

            sb.append(Character.toUpperCase(c));
            count++;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        String s1 = "5F3Z-2e-9-w";
        int k1 = 4;
        System.out.println("Input: " + s1 + ", k = " + k1);
        System.out.println("Output: " + licenseKeyFormatting(s1, k1));

        System.out.println();

        String s2 = "2-5g-3-J";
        int k2 = 2;
        System.out.println("Input: " + s2 + ", k = " + k2);
        System.out.println("Output: " + licenseKeyFormatting(s2, k2));
    }
}

