package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O49 {
    // 已有有序丑数序列X1-Xn，当前所求为Xn+1
    // Xn+1 必为三种情况之一：Xa*2,Xb*3,Xc*5
    // 易知，若Xn+1=Xa*2,序号小于a的元素*2所得的元素都已在队列中，且序号大于a的元素*2所得元素都大于Xn+1，即Xn+1是已有元素*2所得新元素中的最小值
    // 同理，Xa*2,Xb*3,Xc*5分别为*2，*3，*5所得新元素中的最小值
    // Xn+1是三者中的最小值
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n1 = dp[a] * 2, n2 = dp[b] * 3, n3 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n1, n2), n3);
            if (dp[i] == n1) a++;
            if (dp[i] == n2) b++;
            if (dp[i] == n3) c++;
        }
        return dp[n - 1];
    }
}
