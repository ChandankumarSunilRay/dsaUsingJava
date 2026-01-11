package EasyProblems;

import java.util.Arrays;

public class maximumProductOnThreeNumber20 {


    public static int maximumProduct(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        // Two possible maximum products
        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int product2 = nums[0] * nums[1] * nums[n - 1];


        return Math.max(product1, product2);
    }


    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {-1, -2, -3};
        int[] nums4 = {-10, -10, 5, 2};

        System.out.println("Maximum Product: " + maximumProduct(nums1));
        System.out.println("Maximum Product: " + maximumProduct(nums2));
        System.out.println("Maximum Product: " + maximumProduct(nums3));
        System.out.println("Maximum Product: " + maximumProduct(nums4));
    }
}
