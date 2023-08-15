package jzoffer;

import java.util.*;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O48 {
    // 滑动窗口，队列存储最大字串
    public int lengthOfLongestSubstring1(String s) {
        Queue<Character> charSet = new LinkedList<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            while (charSet.contains(s.charAt(i)))
                charSet.poll();
            charSet.offer(s.charAt(i));
            max = Math.max(max, charSet.size());
        }
        return max;
    }

    // 滑动窗口优化，使用HashMap存储上一次出现位置
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> indexMap = new HashMap<>();
        int left = -1, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (indexMap.containsKey(s.charAt(i)))
                left = Math.max(left, indexMap.get(s.charAt(i)));
            indexMap.put(s.charAt(i), i);
            max = Math.max(max, i - left);
        }
        return max;
    }

    // 动态规划
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}
