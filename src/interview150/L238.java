package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int left = 1, right = 1;

        for (int i = 0; i < length; i++) {
            res[i] = left;
            left *= nums[i];
        }
        for (int i = length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
