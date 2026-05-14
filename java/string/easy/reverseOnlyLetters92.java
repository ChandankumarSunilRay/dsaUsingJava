package string.easy;

public class reverseOnlyLetters92 {

    public static String reverseOnlyLetters(String s) {

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            while (left < right && !Character.isLetter(arr[left])) {
                left++;
            }

            while (left < right && !Character.isLetter(arr[right])) {
                right--;
            }

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {

        String s1 = "ab-cd";
        String s2 = "a-bC-dEf-ghIj";
        String s3 = "Test1ng-Leet=code-Q!";

        System.out.println("Input  : " + s1);
        System.out.println("Output : " + reverseOnlyLetters(s1));

        System.out.println();

        System.out.println("Input  : " + s2);
        System.out.println("Output : " + reverseOnlyLetters(s2));

        System.out.println();

        System.out.println("Input  : " + s3);
        System.out.println("Output : " + reverseOnlyLetters(s3));
    }
}