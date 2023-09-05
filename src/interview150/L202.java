package interview150;

import java.util.HashSet;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L202 {
    // 快乐数，首先需要分析得出，位平方和不会越来越大，要么循环，要么归一
    // 方法一：快慢指针找循环，空间O(1)
    public boolean isHappy1(int n) {
        int slow = n, fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    private int bitSquareSum(int num) {
        int sum = 0;
        while (num != 0) {
            int bit = num % 10;
            sum += bit * bit;
            num /= 10;
        }
        return sum;
    }

    // 方法二：哈希表判循环
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = bitSquareSum(n);
        }
        return n == 1;
    }
}
