package string.easy;

import java.util.HashSet;
import java.util.Scanner;

public class longestSubstringWithoutRepeatingCharacters24 {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int result = lengthOfLongestSubstring(input);

        System.out.println("Length of longest substring without repeating characters: " + result);

        sc.close();
    }
}