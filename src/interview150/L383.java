package interview150;

import java.util.HashMap;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L383 {
    // 哈希表
    public boolean canConstruct1(String ransomNote, String magazine) {
        HashMap<Character, Integer> words = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            words.put(ch, words.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            Integer count = words.getOrDefault(ch, 0);
            if (count < 1)
                return false;
            words.put(ch, count - 1);
        }
        return true;
    }

    // 测试toCharArray会不会快一点
    public boolean canConstruct2(String ransomNote, String magazine) {
        HashMap<Character, Integer> words = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            words.put(ch, words.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()) {
            Integer count = words.getOrDefault(ch, 0);
            if (count < 1)
                return false;
            words.put(ch, count - 1);
        }
        return true;
    }

    // 用数组实现
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] charNum = new int[26];
        for (char ch : magazine.toCharArray()) {
            charNum[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (charNum[ch - 'a']-- < 1)
                return false;
        }
        return true;
    }
}
