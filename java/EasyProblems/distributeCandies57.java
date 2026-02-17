package EasyProblems;

import java.util.HashSet;
import java.util.Set;
public class distributeCandies57 {
    public static int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();

        for (int candy : candyType) {
            set.add(candy);
        }

        int uniqueTypes = set.size();
        int maxCandies = candyType.length / 2;

        return Math.min(uniqueTypes, maxCandies);
    }

    public static void main(String[] args) {

        int[] candyType = {1, 1, 2, 2, 3, 3};

        int result = distributeCandies(candyType);

        System.out.println("Maximum different candies sister can eat: " + result);
    }
}
