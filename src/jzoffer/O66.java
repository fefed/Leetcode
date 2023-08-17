package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O66 {
    // 直觉做法：分别进行正序和倒序遍历，求累乘并存储
    public int[] constructArr1(int[] a) {
        int n = a.length;
        if (n == 0) return a;
        int[] pre = new int[n];
        int[] post = new int[n];
        int[] res = new int[n];
        pre[0] = 1;
        post[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * a[i - 1];
            post[i] = post[i - 1] * a[n - i];
        }

        for (int i = 0; i < n; i++) {
            res[i] = pre[i] * post[n - i - 1];
        }
        return res;
    }

    // 空间优化
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        int left = 1, right = 1;
        // left记录左部累乘结果，right记录右边累乘结果
        for (int i = 0; i < n; i++) {
            res[i] = left; // left = a[0]*……a[i-1]
            left *= a[i];
        }
        for (int i = 0; i < n; i++) {
            res[n - 1 - i] *= right; // right = a[n-1]*……a[n-2-i]
            right *= a[n - 1 - i];
        }
        return res;
    }
}
