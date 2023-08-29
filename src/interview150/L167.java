package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L167 {
    // 双指针，不断逼近答案
    // 利用搜索空间图理解(力扣题解）
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target)
                i++;
            else if (sum > target)
                j--;
            else
                return new int[]{i + 1, j + 1};
        }
        return new int[0];
    }
}
