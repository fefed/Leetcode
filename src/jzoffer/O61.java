package jzoffer;

import java.util.Arrays;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O61 {
    // 方法一：排序+遍历+大小王抵消
    public boolean isStraight1(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0)
                zero++;
            else if (nums[i + 1] == nums[i]) {
                return false;
            } else {
                zero -= nums[i + 1] - nums[i] - 1;
                if (zero < 0)
                    return false;
            }
        }
        return true;
    }

    // 方法二：排序+判断 无重复&最大值-最小值<5
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0)
                zero++;
            else if (nums[i + 1] == nums[i]) {
                return false;
            }
        }
        return nums[4] - nums[zero] < 5;
    }
}
