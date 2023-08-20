package interview150;

import java.util.Arrays;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L189 {
    // 直觉做法，借助辅助空间
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int len = nums.length - k;
        int[] tmp = Arrays.copyOf(nums, len);
        int i = 0, j = 0;
        while (i < k) {
            nums[i] = nums[i + len];
            i++;
        }
        while (i < nums.length) {
            nums[i] = tmp[j];
            i++;
            j++;
        }
    }
    // 借助System.arraycopy
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int[] tmp = new int[k];
        System.arraycopy(nums, nums.length - k, tmp, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(tmp, 0, nums, 0, k);
    }

    // 原地：左反转，右翻转，整体反转
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
