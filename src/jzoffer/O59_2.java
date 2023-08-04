package jzoffer;

import java.util.LinkedList;

/**
 * @author 张东亚
 * @version 1.0
 */
class MaxQueue {
    LinkedList<Integer> queue, maxValues;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxValues = new LinkedList<>();
    }

    public int max_value() {
        return maxValues.isEmpty() ? -1 : maxValues.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxValues.isEmpty() && maxValues.peekLast() < value)
            maxValues.pollLast();
        maxValues.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        if (queue.peek().equals(maxValues.peekFirst()))
            maxValues.pollFirst();
        return queue.poll();
    }
}