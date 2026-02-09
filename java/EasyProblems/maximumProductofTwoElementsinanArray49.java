package EasyProblems;

public class maximumProductofTwoElementsinanArray49 {

    public static int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int n : nums) {
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 2};
        int[] nums2 = {1, 5, 4, 5};
        int[] nums3 = {3, 7};

        System.out.println("Output 1: " + maxProduct(nums1));
        System.out.println("Output 2: " + maxProduct(nums2));
        System.out.println("Output 3: " + maxProduct(nums3));
    }
}
