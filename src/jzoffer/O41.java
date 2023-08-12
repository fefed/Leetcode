package jzoffer;

import java.util.*;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O41 {
}

// 利用堆：小根堆保存较大的一半，大根堆保存较小的一半
// 时间复杂度：addNum O(lgn) findMedian O(1)
class MedianFinder {
    Queue<Integer> bigger, smaller;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        bigger = new PriorityQueue<>();
        smaller = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (bigger.size() == smaller.size()) {
            smaller.add(num);
            bigger.add(smaller.poll());
        } else {
            bigger.add(num);
            smaller.add(bigger.poll());
        }
    }

    public double findMedian() {
        if (bigger.size() == smaller.size())
            return (bigger.peek() + smaller.peek()) / 2.0;
        else
            return bigger.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
