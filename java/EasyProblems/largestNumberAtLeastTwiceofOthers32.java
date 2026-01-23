package EasyProblems;

public class largestNumberAtLeastTwiceofOthers32 {

    public int dominantIndex(int[] nums) {
        int max = -1;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }


        for (int i = 0; i < nums.length; i++) {
            if (i != index && max < 2 * nums[i]) {
                return -1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        largestNumberAtLeastTwiceofOthers32 obj =
                new largestNumberAtLeastTwiceofOthers32();

        int[] nums1 = {3, 6, 1, 0};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println("Output 1: " + obj.dominantIndex(nums1));
        System.out.println("Output 2: " + obj.dominantIndex(nums2));
    }
}
