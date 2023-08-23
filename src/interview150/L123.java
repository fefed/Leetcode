package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L123 {
    // DP模板原始做法
    // dp[i][k][0]：最大允许k次交易，第i天后，当前持票0的最大收益， 0 <= i < n
    // dp[i][k][1]：最大允许k次交易，第i天后，当前持票1的最大收益
    public int maxProfit1(int[] prices) {
        // 题目保证prices.length >= 1，所以不需添加此条件判断
        //  if (prices == null || prices.length == 0)
        //      return 0;
        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        dp[0][1][0] = dp[0][2][0] = 0;
        dp[0][1][1] = dp[0][2][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
        }
        return dp[len - 1][2][0];
    }

    // 空间优化版
    public int maxProfit(int[] prices) {
        int profitOver1 = 0, profitOver2 = 0, profitOn1 = -prices[0], profitOn2 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profitOver1 = Math.max(profitOver1, profitOn1 + prices[i]);
            profitOn1 = Math.max(profitOn1, -prices[i]);
            profitOver2 = Math.max(profitOver2, profitOn2 + prices[i]);
            profitOn2 = Math.max(profitOn2, profitOver1 - prices[i]);
        }
        return profitOver2;
    }
}
