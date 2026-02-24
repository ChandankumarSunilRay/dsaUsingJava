package EasyProblems;
import java.util.Arrays;
public class duplicateZeros46 {

    public static void duplicateZeros(int[] arr) {
        int zeros = 0;
        int n = arr.length;

        for (int num : arr) {
            if (num == 0) {
                zeros++;
            }
        }

        int i = n - 1;
        int j = n + zeros - 1;

        while (i < j) {
            if (j < n) {
                arr[j] = arr[i];
            }

            if (arr[i] == 0) {
                j--;
                if (j < n) {
                    arr[j] = 0;
                }
            }

            i--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] arr2 = {1, 2, 3};

        System.out.println("Before: " + Arrays.toString(arr1));
        duplicateZeros(arr1);
        System.out.println("After:  " + Arrays.toString(arr1));

        System.out.println();

        System.out.println("Before: " + Arrays.toString(arr2));
        duplicateZeros(arr2);
        System.out.println("After:  " + Arrays.toString(arr2));
    }
}
