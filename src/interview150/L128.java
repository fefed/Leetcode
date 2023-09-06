package interview150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L128 {
    // 直觉做法：哈希表存长度，连续序列的端点存储该序列长度
    public int longestConsecutive1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                Integer leftLen = map.getOrDefault(num - 1, 0);
                Integer rightLen = map.getOrDefault(num + 1, 0);
                int newLen = leftLen + rightLen + 1;
                if (leftLen != 0) {
                    map.put(num - leftLen, newLen);
                }
                if (rightLen != 0) {
                    map.put(num + rightLen, newLen);
                }
                map.put(num, newLen);
                max = Math.max(max, newLen);
            }
        }
        return max;
    }

    // 哈希set去重，只在连续序列的开始值计算长度
    public int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        // 去重
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            // 序列开始节点才计算长度
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // 排序法解决
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int result = 1;
        int temp = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] != nums[i - 1]) {
                if (nums[i - 1] + 1 == nums[i]) {
                    temp++;
                } else {
                    result = Math.max(temp, result);
                    temp = 1;
                }
            }
            if (i == nums.length - 1)
                result = Math.max(temp, result);

        }

        return result;
    }

    public static void main(String[] args) {
        int res = new L128().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }
}

