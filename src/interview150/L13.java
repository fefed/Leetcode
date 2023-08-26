package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L13 {
    /*
        字符          数值
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
    */
    public int romanToInt1(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i < s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))
                        res -= 1;
                    else res += 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    if (i < s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
                        res -= 10;
                    else res += 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    if (i < s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'))
                        res -= 100;
                    else res += 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }

    // 新奇做法
    public int romanToInt(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += which(s.charAt(i));
        }
        return result;
    }

    public int which(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            case 'a' -> 4;
            case 'b' -> 9;
            case 'c' -> 40;
            case 'd' -> 90;
            case 'e' -> 400;
            case 'f' -> 900;
            default -> 0;
        };
    }
}
