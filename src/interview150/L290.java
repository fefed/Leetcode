package interview150;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L290 {
    // 双向映射
    public boolean wordPattern1(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length)
            return false;
        HashMap<Character, String> map1 = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String str = words[i];
            if (map1.containsKey(ch)){
                if (!map1.get(ch).equals(str))
                    return false;
            }else if (set.contains(str))
                return false;
            else {
                map1.put(ch, str);
                set.add(str);
            }
        }
        return true;
    }
    // 坐标法
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length)
            return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        // 注意i为Integer类型，否则不能用!=来判断
        // 利用了put方法的返回值
        for (Integer i = 0; i < pattern.length(); i++) {
            if (map1.put(pattern.charAt(i), i) != map2.put(words[i], i))
                return false;
        }
        return true;
    }
}
