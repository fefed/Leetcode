package jzoffer;

import java.util.Arrays;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O39 {
    // 直觉做法
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 摩尔投票，不同则抵消，剩下的一定是超过一半的数
    // 时间O(n),空间O(1)
    public int majorityElement(int[] nums) {
        int res = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0)
                res = num;
            if (res == num)
                votes++;
            else
                votes--;
        }
        return res;
    }
}
