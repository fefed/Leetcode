package interview150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L380 {

}

/*
class RandomizedSet {
    ArrayList<Integer> set;
    HashMap<Integer, Integer> index;

    public RandomizedSet() {
        set = new ArrayList<>();
        index = new HashMap<>();
    }

    public boolean insert(int val) {
        if (index.containsKey(val))
            return false;
        set.add(val);
        index.put(val, set.size() - 1); // 哈希表记录元素坐标
        return true;
    }

    public boolean remove(int val) {
        if (!index.containsKey(val))
            return false;
        // 将待删除元素与末尾元素互换
        Integer eleIndex = index.get(val);
        Integer lastEle = set.get(set.size() - 1);
        set.set(eleIndex, lastEle);
        index.put(lastEle, eleIndex);
        // 删除末尾元素
        set.remove(set.size() - 1);
        index.remove(val);
        return true;
    }

    public int getRandom() {
        return set.get(new Random().nextInt(set.size()));
    }
}
 */
// 数组代替ArrayList
class RandomizedSet {
    int[] set = new int[200010];
    HashMap<Integer, Integer> index;
    int idx = -1;

    Random random = new Random();

    public RandomizedSet() {
        index = new HashMap<>();
    }

    public boolean insert(int val) {
        if (index.containsKey(val))
            return false;
        set[++idx] = val;
        index.put(val, idx); // 哈希表记录元素坐标
        return true;
    }

    public boolean remove(int val) {
        if (!index.containsKey(val))
            return false;
        // 将待删除元素与末尾元素互换
        Integer eleIndex = index.remove(val);
        if (eleIndex != idx)
            index.put(set[idx], eleIndex);
        set[eleIndex] = set[idx--];
        return true;
    }

    public int getRandom() {
        return set[random.nextInt(idx + 1)];
    }
}