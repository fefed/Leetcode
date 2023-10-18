package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L191 {
    // 逐位检查
    public int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                res++;
            n >>>= 1;
        }
        return res;
    }

    // 优化：n&(n-1)消去最后一个1
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

    // 优化：n - (n & -n)消去最后一个1
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n -= n & -n;
        }
        return res;
    }
}
