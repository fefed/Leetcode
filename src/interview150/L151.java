package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L151 {
    // 倒序双指针
    public String reverseWords1(String s) {
        StringBuilder res = new StringBuilder();
        s = s.trim();
        int length = s.length();
        int i = length - 1, j = length - 1;
        while (j >= 0) {
            while (j >= 0 && s.charAt(j) != ' ')
                j--;
            res.append(s, j + 1, i + 1).append(" ");
            while (j >= 0 && s.charAt(j) == ' ')
                j--;
            i = j;
        }
        return res.toString().trim();
    }
    // 方法二： split分割，然后反转string数组
}
