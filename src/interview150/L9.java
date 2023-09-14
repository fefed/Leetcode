package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L9 {
    // 回文数
    // 转为字符串
    public boolean isPalindrome1(int x) {
        String num = String.valueOf(x);
        int i = 0, j = num.length() - 1;
        while (i < j) {
            if (num.charAt(i) != num.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }


    // 不适用额外空间，反转一半数字
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int reversedNum = 0;
        while (x > reversedNum) {
            reversedNum = reversedNum * 10 + x % 10;
            x /= 10;
        }
        return reversedNum == x || reversedNum / 10 == x;
    }
}
