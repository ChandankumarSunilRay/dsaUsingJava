package EasyProblems;

import java.util.HashSet;

public class containsDuplicate11 {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }


    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println("Test case 1: " + containsDuplicate(nums1));
        System.out.println("Test case 2: " + containsDuplicate(nums2));
    }
}
