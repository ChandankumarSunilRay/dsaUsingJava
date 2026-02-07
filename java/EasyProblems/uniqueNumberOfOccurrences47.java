package EasyProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class uniqueNumberOfOccurrences47 {

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> seen = new HashSet<>();
        for (int count : countMap.values()) {
            if (!seen.add(count)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        int[] arr2 = {1, 2};
        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};

        System.out.println(uniqueOccurrences(arr1)); // true
        System.out.println(uniqueOccurrences(arr2)); // false
        System.out.println(uniqueOccurrences(arr3)); // true
    }
}
