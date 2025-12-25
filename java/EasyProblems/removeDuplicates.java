package EasyProblems;

public class removeDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        removeDuplicates solution = new removeDuplicates();

        int[] nums = {1, 1, 2, 2, 3};
        int k = solution.removeDuplicates(nums);

        System.out.println("Unique count: " + k);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
