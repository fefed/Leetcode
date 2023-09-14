package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L69 {
    // 二分法
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int left = 0, right = x / 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 防溢出
            if (x / mid < mid)
                right = mid - 1;
            else if (x / mid > mid)
                left = mid;
            else
                return mid;
        }
        return left;
    }
}
