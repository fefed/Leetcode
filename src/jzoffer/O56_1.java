package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O56_1 {
    public int[] singleNumbers(int[] nums) {
        int xorSum = 0, neDigit = 1, res1 = 0, res2 = 0;
        // 求出 res1 xor res2
        for (int num : nums) {
            xorSum ^= num;
        }
        // 找出res1和res2从右向左不同的第一个位置
        while ((xorSum & neDigit) == 0) {
            neDigit <<= 1;
        }
        // 根据上述位置划分数组为两个分别包含res1和res2的子数组
        // 分别求异或和得到res1和res2
        for (int num : nums) {
            if ((num & neDigit) == 0) res1 ^= num;
            else res2 ^= num;
        }
        return new int[]{res1, res2};
    }
}
