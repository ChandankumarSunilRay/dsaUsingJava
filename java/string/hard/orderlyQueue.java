package string.hard;

import java.util.Arrays;

public class orderlyQueue {

    public String orderlyQueue(String s, int k) {

        if (k == 1) {
            String result = s;

            for (int i = 1; i < s.length(); i++) {
                String rotated = s.substring(i) + s.substring(0, i);
                if (rotated.compareTo(result) < 0) {
                    result = rotated;
                }
            }

            return result;
        }

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        orderlyQueue obj = new orderlyQueue();

        String s1 = "cba";
        int k1 = 1;
        System.out.println("Input: " + s1 + ", k = " + k1);
        System.out.println("Output: " + obj.orderlyQueue(s1, k1));

        String s2 = "baaca";
        int k2 = 3;
        System.out.println("\nInput: " + s2 + ", k = " + k2);
        System.out.println("Output: " + obj.orderlyQueue(s2, k2));

        String s3 = "daily";
        int k3 = 1;
        System.out.println("\nInput: " + s3 + ", k = " + k3);
        System.out.println("Output: " + obj.orderlyQueue(s3, k3));
    }
}