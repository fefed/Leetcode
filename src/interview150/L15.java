package interview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L15 {
    // 三数之和：排序加双指针
    // O(n2）注意去重
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) // 剪枝
                return res;
            if (i > 0 && nums[i] == nums[i - 1]) // 去重
                continue;
            int left = i + 1, right = length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < 0)
                    left++;
                else if (sum > 0)
                    right--;
                else {
                    res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while (left < right && left > i + 1 && nums[left] == nums[left - 1]) // 去重
                        left++;
                    while (left < right && right < length - 1 && nums[right] == nums[right + 1])
                        right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new L15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
