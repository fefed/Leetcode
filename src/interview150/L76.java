package interview150;

import java.util.HashMap;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L76 {
    // 滑动窗口，右边界滑动寻找可行解，左边界滑动寻找最优解
    public String minWindow1(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen < tLen) return "";

        HashMap<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            char ch = t.charAt(i);
            chars.put(ch, chars.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0, count = 0, minLen = Integer.MAX_VALUE;
        int minLeft = 0, minRight = 0;
        HashMap<Character, Integer> subString = new HashMap<>();
        while (right < sLen) {
            char cur = s.charAt(right);
            if (chars.containsKey(cur)) {
                int num = subString.getOrDefault(cur, 0) + 1;
                subString.put(cur, num);
                if (num <= chars.get(cur))
                    count++;
                if (count == tLen) {
                    while (count == tLen) {
                        char chLeft = s.charAt(left);
                        if (chars.containsKey(chLeft)) {
                            int chNum = subString.get(chLeft);
                            subString.put(chLeft, chNum - 1);
                            if (chNum <= chars.get(chLeft))
                                count--;
                        }
                        left++;
                    }
                    if (right - left + 2 < minLen) {
                        minLen = right - left + 2;
                        minLeft = left - 1;
                        minRight = right + 1;
                    }
                }
            }
            right++;
        }
        return s.substring(minLeft, minRight);
    }

    // 滑动窗口，数组实现哈希表
    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen < tLen) return "";

        int[] charCount = new int[128];
        for (int i = 0; i < tLen; i++) {
            charCount[t.charAt(i)]++;
        }

        int left = 0, right = 0, count = 0, start = 0, minLen = Integer.MAX_VALUE;
        while (right < sLen) {
            char cur = s.charAt(right);
            // 有剩余”名额“,计数
            if (charCount[cur] > 0) {
                count++;
            }
            charCount[cur]--;
            // 此时，t中字符都被占用，charCount[i] <= 0
            if (count == tLen) {
                // 向右收缩窗口
                while (left < right && charCount[s.charAt(left)] < 0) {
                    charCount[s.charAt(left)]++; // 字符移除，占用”名额“归还
                    left++;
                }
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                // 窗口左端点右移一个字符，重新开始循环
                charCount[s.charAt(left)]++;
                left++;
                count--;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
