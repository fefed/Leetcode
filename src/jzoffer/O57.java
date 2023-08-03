package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O57 {
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (nums[left] + nums[right] < target)
                left ++;
            while (nums[left] + nums[right] > target)
                right --;
            if (nums[left] + nums[right] == target){
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            }
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target)
                left ++;
            else if (sum > target) {
                right --;
            }
            else
                return new int[]{nums[left], nums[right]};
        }
        return new int[0];
    }
}
