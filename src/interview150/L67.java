package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L67 {
    public String addBinary1(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();


        StringBuilder res = new StringBuilder();

        int i = lenA - 1, j = lenB - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            carry = sum / 2;
            res.append(sum % 2);
            i--;
            j--;
        }
        if (carry == 0) {
            if (i >= 0)
                return a.substring(0, i + 1) + res.reverse();
            else if (j >= 0)
                return b.substring(0, j + 1) + res.reverse();
        }
        while (i >= 0) {
            int sum = (a.charAt(i) - '0') + carry;
            carry = sum / 2;
            res.append(sum % 2);
            i--;
        }
        while (j >= 0) {
            int sum = b.charAt(j) - '0' + carry;
            carry = sum / 2;
            res.append(sum % 2);
            j--;
        }
        if (carry == 1)
            res.append(1);
        return res.reverse().toString();
    }

    // 简洁版写法
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            carry = sum / 2;
            res.append(sum % 2);
        }
        if (carry == 1)
            res.append(1);
        return res.reverse().toString();
    }
}
