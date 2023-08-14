package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O10_2 {
    public int numWays(int n) {
        if (n <= 1) return 1;
        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum = (a + b) % 1000000007;
            b = a;
            a = sum;
        }
        return sum;
    }
}
