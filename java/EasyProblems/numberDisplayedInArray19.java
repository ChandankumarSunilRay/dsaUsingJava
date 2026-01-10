package EasyProblems;

import java.util.ArrayList;
import java.util.List;

public class numberDisplayedInArray19 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Missing numbers: " + findDisappearedNumbers(nums1));

        int[] nums2 = {1, 1};
        System.out.println("Missing numbers: " + findDisappearedNumbers(nums2));
    }
}
