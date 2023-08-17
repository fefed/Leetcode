package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O14_2 {
    // 快速幂，大数版
    public int cuttingRope(int n) {
        int mod = 1000000007;
        if (n <= 3)
            return n - 1;
        int a = n / 3 - 1, b = n % 3;
        long res = 1, x = 3; // 注意用long
        // 快速幂
        while (a != 0) {
            if ((a & 1) != 0) res = (res * x) % mod;
            x = (x * x) % mod;
            a >>>= 1;
        }
        if (b == 0)
            return (int) (res * 3 % mod);
        if (b == 1)
            return (int) (res * 4 % mod);
        return (int) (res * 6 % mod);
    }
}
