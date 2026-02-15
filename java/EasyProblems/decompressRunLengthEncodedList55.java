package EasyProblems;

import java.util.Arrays;
public class decompressRunLengthEncodedList55 {

    public static int[] decompressRLElist(int[] nums) {

        int totalLength = 0;
        for (int i = 0; i < nums.length; i += 2) {
            totalLength += nums[i];
        }

        int[] result = new int[totalLength];

        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];

            for (int j = 0; j < freq; j++) {
                result[index++] = val;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] decompressed = decompressRLElist(nums);

        System.out.println("Decompressed List: " + Arrays.toString(decompressed));
    }
}
