package EasyProblems;

import java.util.Arrays;

public class maximizeSumOfArrayAfterKNegations60 {

    public static int largestSumAfterKNegations(int[] nums, int k) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 2, 3};
        int k1 = 1;
        System.out.println("Output 1: " + largestSumAfterKNegations(nums1, k1));

        int[] nums2 = {3, -1, 0, 2};
        int k2 = 3;
        System.out.println("Output 2: " + largestSumAfterKNegations(nums2, k2));

        int[] nums3 = {2, -3, -1, 5, -4};
        int k3 = 2;
        System.out.println("Output 3: " + largestSumAfterKNegations(nums3, k3));
    }
}