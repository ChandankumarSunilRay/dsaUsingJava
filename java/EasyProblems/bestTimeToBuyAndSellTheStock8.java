package EasyProblems;

public class bestTimeToBuyAndSellTheStock8 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

                int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            minPrice = Math.min(minPrice, price);

            int profit = price - minPrice;

            maxProfit = Math.max(maxProfit, profit);
        }


        return maxProfit;
    }

    public static void main(String[] args) {
        bestTimeToBuyAndSellTheStock8 solution = new bestTimeToBuyAndSellTheStock8();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = solution.maxProfit(prices);
        System.out.println("Maximum Profit: " + result);
    }
}
