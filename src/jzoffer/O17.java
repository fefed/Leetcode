package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O17 {
    // 方法一：不考虑大数溢出
    public int[] printNumbers(int n) {
        int max = 9;
        for (int i = 1; i < n; i++) {
            max = max * 10 + 9;
        }
        int[] res = new int[max];
        for (int i = 0; i < res.length; i++) {
            res[i] =  i + 1;
        }
        return res;
    }

    private String[] res;
    private int numCount = 0;
    // 方法二：考虑大数溢出，应该用String来表示数字
    public String[] printBigNumbers(int n) {
        res = new String[(int)(Math.pow(10, n) - 1)];
        // 分别添加1--n位的数字
        for (int i = 1; i <= n; i++) {
            char[] num = new char[i];
            // 给第一位添加数字1-9避免0出现
            for (char ch = '1'; ch <= '9' ; ch++) {
                num[0] = ch;
                dfs(1, num); // 从第2位开始全排列
            }
        }
        return res;
    }

    // n是当前位(从0开始），num是位数固定的char数组，全排列
    private void dfs(int n, char[] num) {
        if (n == num.length) {
            res[numCount++] = String.valueOf(num);
            return;
        }
        for (char ch = '0'; ch <= '9'; ch++) {
            num[n] = ch;
            dfs(n + 1, num);
        }
    }

    public static void main(String[] args) {
        String[] strings = new O17().printBigNumbers(3);
    }
}
