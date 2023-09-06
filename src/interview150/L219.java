package interview150;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L219 {
    // HashMap
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                if (i - map.get(nums[i]) <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    // 滑动窗口+哈希表
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
