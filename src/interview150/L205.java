package interview150;

import java.util.HashMap;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L205 {
    // 双向哈希映射
    public boolean isIsomorphic1(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (map1.containsKey(a)) {
                if (map1.get(a) != b)
                    return false;
            }else if (map2.containsKey(b)){
                return false;
            }else {
                map1.put(a, b);
                map2.put(b, a);
            }
        }
        return true;
    }


    // 数组实现，下标比较
    public boolean isIsomorphic2(String s, String t) {
        int[] preIndexS = new int[128];
        int[] preIndexT = new int[128];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (preIndexS[a] != preIndexT[b])
                return false;
            preIndexS[a] = preIndexT[b] = i + 1; // 注意，设置为i的话，未出现元素和首元素会误判
        }
        return true;
    }

    // indexOf函数实现下标比较
    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i)))
                return false;
        }
        return true;
    }
}
