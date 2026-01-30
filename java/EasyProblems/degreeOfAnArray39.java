package EasyProblems;
import java.util.HashMap;
import java.util.Map;

public class degreeOfAnArray39 {
    public static int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            count.put(num, count.getOrDefault(num, 0) + 1);

            if (!first.containsKey(num)) {
                first.put(num, i);
            }

            last.put(num, i);
        }

        int degree = 0;
        for (int freq : count.values()) {
            degree = Math.max(degree, freq);
        }

        int minLength = nums.length;
        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                int length = last.get(num) - first.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 3, 1};
        System.out.println("Output: " + findShortestSubArray(nums1));

        int[] nums2 = {1, 2, 2, 3, 1, 4, 2};
        System.out.println("Output: " + findShortestSubArray(nums2));
    }
}
