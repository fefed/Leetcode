package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O44 {
    // 暴力遍历，超时
    public int findNthDigit1(int n) {
        int count = 0;
        int index = 0;
        while (count < n) {
            count += String.valueOf(index).length();
            index++;
        }
        if (count == n) {
            return String.valueOf(index).charAt(0) - '0';
        } else {
            String num = String.valueOf(index - 1);
            return num.charAt(num.length() - count + n) - '0';
        }
    }

    // 数学，找规律，按照数字位数统计
    // digit：数字位数
    // start：digit位数字的起始值，比如，2位数起始值为10
    // count：digit位数字的序列总位数，比如，2位数，为2*90 = 190 count = digit*start*9
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1, count = 9; // 注意用long
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return String.valueOf(num).charAt((n - 1) % digit) - '0';
    }
}
