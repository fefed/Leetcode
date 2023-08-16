package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O65 {
    // s = a + b = 非进位和n + 进位c = a^b + a&b<<1;
    public int add(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            a = sum;
            b = carry;
            sum = a ^ b;
            carry = (a & b) << 1;
        }
        return sum;
    }
}
