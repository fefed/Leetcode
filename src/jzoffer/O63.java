package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O63 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            min = Math.min(price, min);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}
