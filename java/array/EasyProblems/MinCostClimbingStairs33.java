package EasyProblems;

public class MinCostClimbingStairs33 {

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return Math.min(prev1, prev2);
    }

    public static void main(String[] args) {

        int[] cost1 = {10, 15, 20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println("Minimum cost (Example 1): "
                + minCostClimbingStairs(cost1));

        System.out.println("Minimum cost (Example 2): "
                + minCostClimbingStairs(cost2));
    }
}
