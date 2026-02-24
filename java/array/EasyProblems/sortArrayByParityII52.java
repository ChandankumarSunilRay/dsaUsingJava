package EasyProblems;

import java.util.Arrays;
public class sortArrayByParityII52 {

    public static int[] sortArrayByParityII(int[] nums) {
        int[] result = new int[nums.length];

        int evenIndex = 0;
        int oddIndex = 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                result[evenIndex] = num;
                evenIndex += 2;
            } else {
                result[oddIndex] = num;
                oddIndex += 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 2, 5, 7};
        int[] nums2 = {2, 3};

        int[] result1 = sortArrayByParityII(nums1);
        int[] result2 = sortArrayByParityII(nums2);

        System.out.println("Input:  " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(result1));

        System.out.println();

        System.out.println("Input:  " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(result2));
    }
}
