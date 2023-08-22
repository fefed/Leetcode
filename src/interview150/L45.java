package interview150;

import java.util.Arrays;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L45 {
    // 直觉做法：动态规划
    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, nums.length);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i)
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    // 贪心做法：每次在当前能跳到的位置中选择一个下一步最远的
    public int jump(int[] nums) {
        int end = 0, maxPosition = 0, step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                step++;
                if (maxPosition >= nums.length - 1)
                    return step;
                end = maxPosition;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int jump = new L45().jump(new int[]{2, 3, 1, 1, 4});
    }
}
