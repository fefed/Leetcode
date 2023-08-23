package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L714 {
    // 带有续费的股票问题
    // DP模板稍作修改，在买入或者卖出时减去手续费
    public int maxProfit(int[] prices, int fee) {
        int profit0 = 0, profit1 = -prices[0] - fee; // 初始化别忘记减去fee
        for (int i = 1; i < prices.length; i++) {
            int newProfit0 = Math.max(profit0, profit1 + prices[i]);
            profit1 = Math.max(profit1, profit0 - prices[i] - fee);
            profit0 = newProfit0;
        }
        return profit0;
    }
}
