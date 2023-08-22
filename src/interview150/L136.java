package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
