package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O46 {
    // 原始做法
    // dp[i]：1-i位数字的翻译方案数
    public int translateNum1(int num) {
        String numStr = String.valueOf(num);
        char[] nums = numStr.toCharArray();
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == '1' || (nums[i - 1] == '2' && nums[i] <= '5'))
                dp[i + 1] = dp[i] + dp[i - 1];
            else
                dp[i + 1] = dp[i];
        }
        return dp[n];
    }

    // 空间优化
    public int translateNum2(int num) {
        String numStr = String.valueOf(num);
        char[] nums = numStr.toCharArray();
        int preNum = 1, prePreNum = 1, curNum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == '1' || (nums[i - 1] == '2' && nums[i] <= '5'))
                curNum = preNum + prePreNum;
            else
                curNum = preNum;
            prePreNum = preNum;
            preNum = curNum;
        }
        return curNum;
    }

    // 再优化
    public int translateNum(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
