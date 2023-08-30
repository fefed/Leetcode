package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L209 {
    // 滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = 0;
        while (j < nums.length) {
            while (j < nums.length && sum < target){
                sum += nums[j++];
            }
            if (sum < target)
                break;
            while (sum >= target) {
                sum -= nums[i];
                i++;
            }
            minLen = Math.min(minLen, j - i + 1);
            if (minLen == 1)
                return 1;
        }
        return minLen < Integer.MAX_VALUE ? minLen : 0;
    }

    public static void main(String[] args) {
        int len = new L209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }
}
