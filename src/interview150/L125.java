package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L125 {
    // 原始做法
    public boolean isPalindrome1(String s) {
        StringBuilder res = new StringBuilder();
        // 首先，只保留字母数字字符
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z'))
                res.append(ch);
        }
        // 转小写
        s = res.toString().toLowerCase();
        // 双指针
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // 利用包装类API
    public boolean isPalindrome2(String s) {
        StringBuilder res = new StringBuilder();
        // 首先，只保留字母数字字符
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch))
                res.append(Character.toLowerCase(ch));
        }
        // 双指针
        int i = 0, j = res.length() - 1;
        while (i < j) {
            if (res.charAt(i) != res.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // 原地判断，空间复杂度O(1)
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }
}
