package EasyProblems;

public class majorityElement10 {

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }


    public static void main(String[] args) {
        majorityElement10 solution = new majorityElement10();

        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Majority Element (Example 1): " + solution.majorityElement(nums1));
        System.out.println("Majority Element (Example 2): " + solution.majorityElement(nums2));
    }
}


