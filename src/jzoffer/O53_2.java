package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O53_2 {
    public int missingNumber(int[] nums) {
        int st = 0, ed = nums.length - 1;
        while (st < ed) {
            int mid = st + ed >> 1;
            if (nums[mid] != mid) ed = mid;
            else st = mid + 1;
        }
        if (nums[st] == st) return st + 1;
        return st;
    }
}
