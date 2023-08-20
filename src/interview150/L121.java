package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L121 {
    public int maxProfit(int[] prices) {
        int minPoint = Integer.MAX_VALUE, maxValue = 0;
        for (int price : prices) {
            minPoint = Math.min(minPoint, price);
            maxValue = Math.max(price - minPoint, maxValue);
        }
        return maxValue;
    }
}
