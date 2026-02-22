package string.easy;

import java.util.*;
public class minimumIndexSumOfTwoLists1 {
    public static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {

            if (map.containsKey(list2[j])) {

                int sum = j + map.get(list2[j]);

                if (sum < minSum) {
                    result.clear();
                    result.add(list2[j]);
                    minSum = sum;
                } else if (sum == minSum) {
                    result.add(list2[j]);
                }
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {

        String[] list1 = {"happy", "sad", "good"};
        String[] list2 = {"sad", "happy", "good"};

        String[] result = findRestaurant(list1, list2);

        System.out.println("Common strings with least index sum:");
        for (String str : result) {
            System.out.println(str);
        }
    }
}