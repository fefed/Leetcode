package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L26 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num != nums[i])
                nums[++i] = num;
        }
        return i + 1;
    }
}
