package EasyProblems;

import java.util.Arrays;

public class largestPerimeterTriangle51 {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }

        return 0;
    }

    // Main method for manual execution
    public static void main(String[] args) {

        largestPerimeterTriangle51 solution = new largestPerimeterTriangle51();

        int[] nums1 = {2, 1, 2};
        int[] nums2 = {1, 2, 1, 10};

        System.out.println("Largest Perimeter (Example 1): " + solution.largestPerimeter(nums1));
        System.out.println("Largest Perimeter (Example 2): " + solution.largestPerimeter(nums2));
    }
}
