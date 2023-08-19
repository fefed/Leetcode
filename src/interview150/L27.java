package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L27 {
    // 移除元素：发现目标元素后与末尾元素替换，避免元素移动
    public int removeElement1(int[] nums, int val) {
        int i = 0, j = nums.length;
        while (i < j) {
            if (nums[i] == val){
                nums[i] = nums[--j];
            }else
                i++;
        }
        return j;
    }

    // 移除元素：发现目标元素后与index元素替换，避免元素移动
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (num != val)
                nums[i++] = num;
        }
        return i;
    }

}
