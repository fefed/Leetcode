package interview150;

import java.util.LinkedHashMap;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L146 {

}
// O(1)复杂度实现LRU
// O(1)实现通过key获取value：哈希
// O(1)实现排序：链表
// 综合，LinkedHashMap => 哈希表+双向链表
@SuppressWarnings("unused")
class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Integer val = map.get(key);
        // 删除后插到末尾 => 最新访问元素
        map.remove(key);
        map.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        // 存在则更新元素值和访问顺序
        if (map.containsKey(key)){
            map.remove(key);
            map.put(key, value);
            return;
        }
        // 不存在，则插入末尾
        map.put(key, value);
        // 超过容量，则删除首元素 => 最久未被访问的元素
        if (map.size() > capacity){
            map.remove(map.keySet().iterator().next());
        }
    }
}