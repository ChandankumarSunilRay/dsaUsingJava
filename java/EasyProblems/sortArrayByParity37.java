package EasyProblems;
import java.util.Arrays;
public class sortArrayByParity37 {

    public static int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                result[index++] = num;
            }
        }

        for (int num : nums) {
            if (num % 2 != 0) {
                result[index++] = num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};

        int[] result = sortArrayByParity(nums);

        System.out.println("Output: " + Arrays.toString(result));
    }
}