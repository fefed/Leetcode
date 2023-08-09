package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O64 {
    // 方法一：迭代和公式不可用，用递归，但不可用条件判断语句 ==> 借助&& || 实现
    public int sumNums1(int n) {
        boolean flag = n > 1 && (n += sumNums1(n - 1)) > 0;
        return n;
    }

    public int sumNums2(int n) {
        boolean flag = n == 0 || (n += sumNums2(n - 1)) > 0;
        return n;
    }

    // 方法二：利用库函数隐式使用乘法
    // sizeof(new int[n][n+1])/2 ，Java中不可用
}
