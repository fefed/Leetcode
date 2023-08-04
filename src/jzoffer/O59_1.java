package jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> desc = new LinkedList<>();
        // 划分情况：减少冗余判断
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            while (!desc.isEmpty() && nums[i] >= nums[desc.peekLast()])
                desc.pollLast();
            desc.offer(i);
        }
        res[0] = nums[desc.peekFirst()];
        // 已形成窗口
        for (int i = k; i < nums.length; i++) {
            if (desc.peekFirst() < i - k + 1)
                desc.pollFirst();
            while (!desc.isEmpty() && nums[i] >= nums[desc.peekLast()])
                desc.pollLast();
            desc.offer(i);
            res[i - k + 1] = nums[desc.peekFirst()];
        }
        return res;
    }
}
