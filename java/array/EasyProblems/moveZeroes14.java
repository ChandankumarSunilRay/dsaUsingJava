package EasyProblems;

import java.util.Arrays;

public class moveZeroes14 {

    public static void moveZeroes(int[] nums) {
        int pos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        while (pos < nums.length) {
            nums[pos] = 0;
            pos++;
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("Before: " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("After:  " + Arrays.toString(nums));
    }
}
