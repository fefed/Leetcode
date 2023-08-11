package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O16 {
    // 方法一: 分治+递归
    public double myPow1(double x, int n) {
        if (x == 0) return 0.0;
        if (n > 0)
            return powHelper(x, n);
        return 1.0 / powHelper(x, Math.abs(n));
    }

    private double powHelper(double x, int n) {
        if (n == 0) return 1.0;

        double sqrt = powHelper(x, n / 2);
        if (n % 2 == 0)
            return  sqrt * sqrt;
        else
            return sqrt * sqrt * x;
    }
    // 方法二：利用二进制做快速幂
    public double myPow(double x, int n) {
        if (x == 0) return 0.0;
        long e = n; // 防止n = int_min转化为-n时溢出
        // 若e < 0 转化一下
        if (e < 0) {
            x = 1 / x;
            e = - e;
        }
        double res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res *= x;
            x *= x;
            e >>= 1;
        }
        return res;
    }
}
