package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L14 {
    // 按列扫描
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
