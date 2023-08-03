package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O21 {
    public static int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right)
        {
            // 左指针找一个偶数
            while (left < right && nums[left] % 2 == 1){
                left ++;
            }
            // 右指针找一个奇数
            while (left < right && nums[right] % 2 == 0){
                right --;
            }
            // 找到就交换
            if (left < right) {
                nums[left] ^= nums[right];
                nums[right] ^= nums[left];
                nums[left] ^= nums[right];
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ints = exchange(nums);
    }
}
