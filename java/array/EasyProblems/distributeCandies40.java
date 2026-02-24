package EasyProblems;
import java.util.HashSet;
public class distributeCandies40 {

    public static int distributeCandies(int[] candyType) {
        HashSet<Integer> types = new HashSet<>();

        for (int candy : candyType) {
            types.add(candy);
        }

        int maxAllowed = candyType.length / 2;

        return Math.min(types.size(), maxAllowed);
    }

    public static void main(String[] args) {

        int[] example1 = {1, 1, 2, 2, 3, 3};
        int[] example2 = {1, 1, 2, 3};
        int[] example3 = {6, 6, 6, 6};

        System.out.println("Example 1 Output: " + distributeCandies(example1)); // 3
        System.out.println("Example 2 Output: " + distributeCandies(example2)); // 2
        System.out.println("Example 3 Output: " + distributeCandies(example3)); // 1
    }
}
