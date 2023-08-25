package interview150;

import java.util.HashMap;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L1 {
    // 原始暴力
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j])
                    return new int[]{i, j};
            }
        }
        return new int[0];
    }

    // 哈希法
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
