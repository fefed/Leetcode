package interview150;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L3 {
    // 滑动窗口：利用hashset判断是否包含
    public int lengthOfLongestSubstring1(String s) {
        int i = 0, j = 0, n = s.length(), maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < n) {
            char ch = s.charAt(j);
            // 从前向后去重
            while (set.contains(ch)) {
                set.remove(s.charAt(i));
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            set.add(s.charAt(j++));
        }
        return maxLen;
    }

    // 滑动窗口：利用hashmap判断是否包含并存储坐标
    public int lengthOfLongestSubstring2(String s) {
        int maxLen = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch))
                left = Math.max(left, map.get(ch) + 1);
            maxLen = Math.max(maxLen, i - left + 1);
            map.put(ch, i++);
        }

        return maxLen;
    }

    // 滑动窗口，空间O(1)
    public int lengthOfLongestSubstring(String s) {
        int m = s.length();
        if (m == 0) {
            return 0;
        }
        int num = 1;  //初始值表示以s的第一个字符为结束的不重复的最长子串
        int max = 1;
        for (int i = 1; i < m; i++) {
            int index = s.indexOf(s.charAt(i), i - num);
            if (index < i) {  //num更新，表示以s的第i+1个字符为结束的不重复的最长子串
                num = i - index;
            } else {
                num = num + 1;
            }
            max = Math.max(max, num);
        }
        return max;
    }
}