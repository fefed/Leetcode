package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O53_1 {
    // 二分法寻边界
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1; // 注意边界条件
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        if (nums[l] != target) return 0;
        int right = l;
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        int left = l;
        return right - left + 1;
    }
}
