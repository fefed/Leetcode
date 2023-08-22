package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L55 {
    public boolean canJump(int[] nums) {
        int max = 0, i = 0;
        while (i <= max) {
            max = Math.max(i + nums[i], max);
            if (max >= nums.length - 1)
                return true;
            i++;
        }
        return false;
    }
}
