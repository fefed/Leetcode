package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O03 {
    // 类似哈希法，记录出现次数，空间O(n)
    public int findRepeatNumber1(int[] nums) {
        int[] count = new int[nums.length];
        for (int num : nums) {
            if (count[num] != 0)
                return num;
            else count[num]++;
        }
        return -1;
    }

    // 原地交换：把值x交换到位置x,如果x位置已经为x，那么重复，空间O(1)
    public int findRepeatNumber(int[] nums) {
        int i = 0; // 从0开始
        while (i < nums.length) {
            while (i < nums.length && nums[i] == i)
                i++;
            if (nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
