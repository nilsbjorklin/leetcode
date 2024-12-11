package leetcode.best_time_to_buy_and_sell_stock;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int lowest = 0, highest = 0, max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[highest] - prices[lowest], max);
            if (prices[i] < prices[lowest]) {
                lowest = i;
                highest = i;
            } else if (prices[i] > prices[highest]) {
                highest = i;
            }
        }
        return Math.max(prices[highest] - prices[lowest], max);
    }
}