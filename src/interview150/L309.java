package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L309 {
    // 带冷却期的股票问题
    // DP模板:1.k为无穷大；2.转移方程修改
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int preProfitOver = 0, profitOver = 0, profitOn = -prices[0];
        for (int i = 1; i < len; i++) {
            int newProfitOver = Math.max(profitOver, profitOn + prices[i]);
            profitOn = Math.max(profitOn, preProfitOver - prices[i]);
            preProfitOver = profitOver;
            profitOver = newProfitOver;
        }
        return profitOver;
    }
}
