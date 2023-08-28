package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L6 {
    // 利用Z字形的下标变化规律，巧用flag进行“拐弯”
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        StringBuilder[] strings = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            strings[i] = new StringBuilder();
        }
        int i = 0, flag = - 1;
        for (int j = 0; j < s.length(); j++) {
            strings[i].append(s.charAt(j));
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            res.append(strings[k]);
        }
        return res.toString();
    }
}
