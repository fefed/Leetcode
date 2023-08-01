package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O67 {
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) return 0;
        int sign = 1, start = 1;
        long res = 0;
        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] != '+') {
            start = 0;
        }
        for (int i = start; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') break;
            res = res * 10 + (chars[i] - '0');
            int INT_MAX = 2147483647;
            int INT_MIN = -2147483648;
            if(res > INT_MAX)
                return sign == 1 ? INT_MAX : INT_MIN;
        }
        return (int)res * sign;
    }
}
