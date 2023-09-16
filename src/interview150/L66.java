package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i > 0; i--) {
            if (digits[i] == 9)
                digits[i] = 0;
            else {
                digits[i]++;
                return digits;
            }
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
