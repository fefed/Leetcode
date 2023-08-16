package jzoffer;

import java.util.Arrays;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O60 {
    // 原始版本
    // dp[i][j] 表示i个骰子掷出点数和为j的概率
    public double[] dicesProbability1(int n) {
        double[][] dp = new double[n+1][6*n+1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1.0 / 6;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                double sum = 0;
                for (int k = 1; k <= 6; k++) {
                    if (j > k) sum += dp[i-1][j-k];
                }
                dp[i][j] = sum / 6;
            }
        }
        double[] res = new double[5*n+1];
        System.arraycopy(dp[n], n, res, 0, 5 * n + 1);
        return res;
    }

    // 逆向递推改为正向，考虑dp[i][j]会影响dp[i+1][j+1]……dp[i+1][j+6]
    // 从而避免了越界判断
    public double[] dicesProbability2(int n) {
        double[][] dp = new double[n+1][6*n+1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1.0 / 6;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    dp[i+1][j+k] += dp[i][j] / 6.0;
                }
            }
        }
        double[] res = new double[5*n+1];
        System.arraycopy(dp[n], n, res, 0, 5 * n + 1);
        return res;
    }

    // 空间优化，使用一维
    public double[] dicesProbability3(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] probabilities = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    probabilities[j + k] += dp[j] / 6.0;
                }
            }
            dp = probabilities;
        }
        return dp;
    }
}
