package jzoffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O50 {
    // 利用数组实现哈希
    public char firstUniqChar1(String s) {
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            counts[ch - 'a']++;
        }
        for (char ch : chars) {
            if (counts[ch - 'a'] == 1)
                return ch;
        }
        return ' ';
    }

    // 利用有序哈希表，第二轮遍历轮数更少
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
