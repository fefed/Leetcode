package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L122 {
    public int maxProfit1(int[] prices) {
        int profit = 0;
        int low = Integer.MAX_VALUE, high = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < high) {
                profit += high - low;
                high = low = price;
            }else
                high = price;
        }
        profit += high - low;
        return profit;
    }

    // 贪心
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) profit += diff;
        }
        return profit;
    }
}
