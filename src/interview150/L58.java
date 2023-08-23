package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L58 {

    // 直觉做法
    public int lengthOfLastWord1(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length - 1].length();
    }

    // 从后往前遍历
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ')
            end --;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ')
            start--;
        return end - start;
    }
}
