package EasyProblems;

import java.util.Arrays;

public class setMismatch25 {

    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];


        for (int num : nums) {
            count[num]++;
        }

        int duplicate = -1;
        int missing = -1;


        for (int i = 1; i <= n; i++) {
            if (count[i] == 2) {
                duplicate = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }


    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 4};
        int[] result1 = findErrorNums(nums1);
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(result1));

        int[] nums2 = {1, 1};
        int[] result2 = findErrorNums(nums2);
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(result2));
    }
}
