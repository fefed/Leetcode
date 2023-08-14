package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O10_1 {
    // 基础版
    public int fib1(int n) {
        if (n <= 1) return n;
        int[] fibs = new int[n + 1];
        fibs[0] = 0;
        fibs[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibs[i] = (fibs[i - 1] + fibs[i - 2]) % 1000000007;
        }
        return fibs[n];
    }

    // 内存优化版
    public int fib(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
