package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O43 {
    // 方法一：纯粹暴力，超时
    public int countDigitOne1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1')
                    count++;
            }
        }
        return count;
    }
    // 方法二：固定某位，分类讨论其为1的所有组成情况
    public int countDigitOne(int n) {
        int count = 0, digit = 1;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0){
            if (cur == 0)
                count += high * digit;
            else if (cur == 1)
                count += high * digit + low + 1;
            else
                count += (high + 1)*digit;
            low += cur*digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return count;
    }
}
