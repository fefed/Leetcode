package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O42 {
    // 原始方法
    public int maxSubArray1(int[] nums) {
        // dp[i]表示以nums[i]结尾的连续子数组的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) dp[i] = dp[i - 1] + nums[i];
            else dp[i] = nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 内存优化版
    public int maxSubArray(int[] nums) {
        // dp[i]表示以nums[i]结尾的连续子数组的最大和
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
