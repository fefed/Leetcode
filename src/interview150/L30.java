package interview150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // allWords: Hashmap, 存储words中的单词及出现次数
        Map<String, Integer> allWords = new HashMap<>();
        for (String word : words)
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);

        int wordLen = words[0].length();
        int wordNum = words.length;
        // 按单词长度分类，以下标[0-wordLen)起始，每次移动一个单词长度
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> hasWords = new HashMap<>();
            // count统计已经匹配的元素的个数
            int l = i, r = i, count = 0;
            // l表示已匹配元素的左端点 r表示右端点
            while (r + wordLen <= s.length()) {
                // 取下一个单词
                String word = s.substring(r, r + wordLen);
                r += wordLen;
                // 该单词不在allWords中，直接跳转，以到下一单词作为开始进行判断
                if (!allWords.containsKey(word)) {
                    l = r;
                    count = 0;
                    hasWords.clear();
                } else {
                    hasWords.put(word, hasWords.getOrDefault(word, 0) + 1);
                    count++;
                    // 该单词在allWords中，但是出现次数超额
                    while (hasWords.get(word) > allWords.get(word)) {
                        // 从左侧开始移除已匹配单词
                        String first = s.substring(l, l + wordLen);
                        hasWords.put(first, hasWords.getOrDefault(first, 0) - 1);
                        count--;
                        // 左端点前移
                        l += wordLen;
                    }
                    if (count == wordNum) {
                        res.add(l);
                        //当完全匹配之时，左端点右移一个单词，继续判断
                        String first = s.substring(l, l + wordLen);
                        hasWords.put(first, hasWords.get(first) - 1);
                        count--;
                        l += wordLen;
                    }
                }
            }
        }
        return res;
    }
}