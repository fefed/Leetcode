package jzoffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O56_2 {
    // 原始方法，hashmap存储次数
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (counts.containsKey(num))
                counts.put(num, counts.get(num) + 1);
            else
                counts.put(num, 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = counts.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }

    // 统计所有数字在各位上1的个数，mod3取余后为0，res该位为0；取余为1，res该位为1
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += num & 1;
                num >>>= 1;
            }
        }

        int res = 0, mod = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % mod;
        }
        return res;
    }
}
