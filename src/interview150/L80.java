package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L80 {
    // 双指针
    public int removeDuplicates1(int[] nums) {
        int index = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index]) {
                count++;
                if (count <= 2)
                    nums[++index] = nums[i];
            } else {
                nums[++index] = nums[i];
                count = 1;
            }
        }
        return index + 1;
    }

    // 换种写法
    public int removeDuplicates(int[] nums) {
        int index = 0, k = 2;
        for (int x : nums) {
            if (index < k || nums[index - k] != x)
                nums[index++] = x;
        }
        return index;
    }
}
