package EasyProblems;

import java.util.*;

public class addToArrayformOfInteger54 {

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();

        int i = num.length - 1;

        while (i >= 0 || k > 0) {

            if (i >= 0) {
                k += num[i];
                i--;
            }

            result.add(0, k % 10);
            k /= 10;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] num1 = {1, 2, 0, 0};
        int k1 = 34;
        System.out.println("Input: [1,2,0,0], k = 34");
        System.out.println("Output: " + addToArrayForm(num1, k1));

        int[] num2 = {2, 7, 4};
        int k2 = 181;
        System.out.println("\nInput: [2,7,4], k = 181");
        System.out.println("Output: " + addToArrayForm(num2, k2));

        int[] num3 = {2, 1, 5};
        int k3 = 806;
        System.out.println("\nInput: [2,1,5], k = 806");
        System.out.println("Output: " + addToArrayForm(num3, k3));
    }
}