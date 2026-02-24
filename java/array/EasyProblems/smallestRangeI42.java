package EasyProblems;

public class smallestRangeI42 {

    public static int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return Math.max(0, max - min - 2 * k);
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int k1 = 0;
        System.out.println("Output: " + smallestRangeI(nums1, k1));

        int[] nums2 = {0, 10};
        int k2 = 2;
        System.out.println("Output: " + smallestRangeI(nums2, k2));

        int[] nums3 = {1, 3, 6};
        int k3 = 3;
        System.out.println("Output: " + smallestRangeI(nums3, k3));
    }
}
