package EasyProblems;
import java.util.ArrayList;
import java.util.List;

public class binaryPrefixDivisibleByFive45 {

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int curr = 0;

        for (int bit : nums) {
            curr = (curr * 2 + bit) % 5;
            result.add(curr == 0);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 1};
        int[] nums2 = {1, 1, 1};

        System.out.println("Input: [0, 1, 1]");
        System.out.println("Output: " + prefixesDivBy5(nums1));

        System.out.println();

        System.out.println("Input: [1, 1, 1]");
        System.out.println("Output: " + prefixesDivBy5(nums2));
    }
}