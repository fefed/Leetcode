package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L169 {
    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int res = nums[0], votes = 1;
        for (int i = 1; i < nums.length; i++) {
            if (votes == 0) {
                res = nums[i];
            }
            if (nums[i] != res)
                votes--;
            else
                votes++;
        }
        return res;
    }
}
