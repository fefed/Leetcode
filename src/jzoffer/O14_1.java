package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O14_1 {
    // dp解决
    public int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        // 各长度最大积初始值为本身，不包括n
        for (int i = 1; i < n; i++) {
            dp[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[j] * dp[i - j], dp[i]);
            }
        }
        return dp[n];
    }

    // 数学推导：切分为长度为3的段尽可能多，按剩余段长度做个分类
    public int cuttingRope(int n) {
        if(n <= 3)
            return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0)
            return (int)Math.pow(3, a);
        if(b == 1)
            return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
}
