package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L188 {

    // 股票问题 => DP模板
    // 优化一：应注意到：当k>=n/2时，k就不再是限制交易利润的条件，此时，问题可以转化为k=∞的问题
    // 优化二：空间优化
    // 复杂度：时间O(nk)，空间O(k)
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2)
            return maxProfit(prices);
        int[][] dp = new int[k+1][2];
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            // 此处需要倒序，否则更新后的第i天数据会覆盖第i-1天数据
            for (int j = k; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j-1][0]-prices[i]);
            }
        }
        return dp[k][0];
    }

    private int maxProfit(int[] prices) {
        int profitOver = 0, profitOn = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int newProfitOver = Math.max(profitOver, profitOn + prices[i]);
            profitOn = Math.max(profitOn, profitOver - prices[i]);
            profitOver = newProfitOver;
        }
        return profitOver;
    }
}
