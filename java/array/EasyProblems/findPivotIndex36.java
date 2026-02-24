package EasyProblems;

public class findPivotIndex36 {

    public static int pivotIndex(int[] nums) {
        int totalSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {2, 1, -1};

        System.out.println("Pivot Index (nums1): " + pivotIndex(nums1));
        System.out.println("Pivot Index (nums2): " + pivotIndex(nums2));
        System.out.println("Pivot Index (nums3): " + pivotIndex(nums3));
    }
}
