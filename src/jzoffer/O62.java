package jzoffer;

import java.util.ArrayList;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O62 {
    // 约瑟夫环
    // 方法一：模拟链表
    public int lastRemaining1(int n, int m) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            nums.remove(index);
            n--;
        }
        return nums.get(0);
    }

    // 方法二：数学解法，倒推坐标
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
