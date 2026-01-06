package EasyProblems;

import java.util.ArrayList;
import java.util.List;

public class summeryRanges15 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {

            if (i == nums.length || nums[i] != nums[i - 1] + 1) {

                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                }
                else {
                    result.add(start + "->" + nums[i - 1]);
                }

                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {0, 1, 2, 4, 5, 7};
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        int[] nums3 = {};

        System.out.println("Input: [0,1,2,4,5,7]");
        System.out.println("Output: " + summaryRanges(nums1));

        System.out.println("\nInput: [0,2,3,4,6,8,9]");
        System.out.println("Output: " + summaryRanges(nums2));

        System.out.println("\nInput: []");
        System.out.println("Output: " + summaryRanges(nums3));
    }
}
