package EasyProblems;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class fairCandySwap56 {

    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA = 0, sumB = 0;

        for (int a : aliceSizes) {
            sumA += a;
        }

        for (int b : bobSizes) {
            sumB += b;
        }

        int diff = (sumA - sumB) / 2;

        Set<Integer> setA = new HashSet<>();
        for (int a : aliceSizes) {
            setA.add(a);
        }

        for (int b : bobSizes) {
            if (setA.contains(b + diff)) {
                return new int[]{b + diff, b};
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {

        int[] alice = {1, 2};
        int[] bob = {2, 3};

        int[] result = fairCandySwap(alice, bob);

        System.out.println("Alice should give: " + result[0]);
        System.out.println("Bob should give: " + result[1]);
        System.out.println("Result Array: " + Arrays.toString(result));
    }
}
