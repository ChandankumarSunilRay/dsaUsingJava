package string.easy;

public class truncateSentence90 {

    public static String truncateSentence(String s, int k) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                count++;

                if (count == k) {
                    return s.substring(0, i);
                }
            }
        }

        return s;
    }

    public static void main(String[] args) {

        String s1 = "Hello how are you Contestant";
        int k1 = 4;

        String result1 = truncateSentence(s1, k1);

        System.out.println("Input  : " + s1);
        System.out.println("k      : " + k1);
        System.out.println("Output : " + result1);

        System.out.println();

        String s2 = "What is the solution to this problem";
        int k2 = 4;

        String result2 = truncateSentence(s2, k2);

        System.out.println("Input  : " + s2);
        System.out.println("k      : " + k2);
        System.out.println("Output : " + result2);
    }
}