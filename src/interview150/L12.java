package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L12 {
    // 纯粹暴力
    public String intToRoman1(int num) {
        StringBuilder res = new StringBuilder();
        int kilo = num / 1000;
        res.append("M".repeat(kilo));
        num %= 1000;
        int hundred = num / 100;
        if (hundred % 5 == 4) {
            res.append("C");
            if (hundred / 5 == 0)
                res.append("D");
            else
                res.append("M");
        } else {
            if (hundred / 5 == 1)
                res.append("D");
            res.append("C".repeat(hundred % 5));
        }
        num %= 100;
        int ten = num / 10;
        if (ten % 5 == 4) {
            res.append("X");
            if (ten / 5 == 0)
                res.append("L");
            else
                res.append("C");
        } else {
            if (ten / 5 == 1)
                res.append("L");
            res.append("X".repeat(ten % 5));
        }
        num %= 10;
        int one = num;
        if (one % 5 == 4) {
            res.append("I");
            if (one / 5 == 0)
                res.append("V");
            else
                res.append("X");
        } else {
            if (one / 5 == 1)
                res.append("V");
            res.append("I".repeat(one % 5));
        }
        return res.toString();
    }

    // 硬编码
    public String intToRoman2(int num) {
        StringBuilder res = new StringBuilder();
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return res.append(thousands[num / 1000]).append(hundreds[num % 1000 / 100]).
                append(tens[num % 100 / 10]).append(ones[num % 10]).toString();
    }

    // 贪心，每次选择尽可能大的数字进行匹配
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                res.append(symbols[i]);
                num -= values[i];
            }
            if (num == 0)
                break;
        }
        return res.toString();
    }
}
