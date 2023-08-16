package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O15 {
    // 复杂度O(lgn)
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    // 复杂度O(m)
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n -= n & (-n);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int count = new O15().hammingWeight(11);
    }
}
