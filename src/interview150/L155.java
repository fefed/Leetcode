package interview150;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L155 {

}
@SuppressWarnings("unused")
class MinStack {
    private final LinkedList<Integer> stack;
    private final LinkedList<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        stack.offer(val);
        if (minStack.isEmpty() || val <= minStack.getLast())
            minStack.offer(val);
    }

    public void pop() {
        if (Objects.equals(minStack.getLast(), stack.pollLast())){
            minStack.pollLast();
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minStack.getLast();
    }
}