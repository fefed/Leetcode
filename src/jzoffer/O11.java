package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O11 {
    // 线性搜索，O(n)
    public int minArray1(int[] numbers) {
        int i = numbers.length - 2;
        while (i >= 0) {
            if (numbers[i] > numbers[i + 1])
                break;
            i--;
        }
        return numbers[i + 1];
    }
    // 二分搜索，O(lgn)
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
}
