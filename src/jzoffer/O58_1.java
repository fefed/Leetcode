package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O58_1 {
    public String reverseWords1(String s) {
        char[] chars = s.trim().toCharArray();
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            StringBuilder word = new StringBuilder();
            while (i < chars.length && chars[i] != ' ') {
                word.append(chars[i]);
                i++;
            }
            res = word.append(" ").append(res);
            while (i < chars.length && chars[i] == ' ')
                i++;
        }
        return res.toString().trim();
    }

    public String reverseWords2(String s) {
        String str = s.trim();
        int j = str.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && str.charAt(i) != ' ') i--;
            res.append(str, i + 1, j + 1).append(" ");
            while (i >= 0 && str.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();
    }
}
