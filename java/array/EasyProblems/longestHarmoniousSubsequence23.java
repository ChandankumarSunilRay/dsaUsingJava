package EasyProblems;

import java.util.HashMap;
import java.util.Map;

public class longestHarmoniousSubsequence23 {

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();


        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;


        for (int key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                int currentLength = freq.get(key) + freq.get(key + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 2, 2, 5, 2, 3, 7};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 1};

        System.out.println("Output 1: " + findLHS(nums1));
        System.out.println("Output 2: " + findLHS(nums2));
        System.out.println("Output 3: " + findLHS(nums3));
    }
}
