package jzoffer;

import java.util.Stack;

/**
 * @author 张东亚
 * @version 1.0
 */
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> a, b;
    public MinStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.push(x);
        if (b.empty() || b.peek() >= x)
            b.push(x);
    }

    public void pop() {
        if (b.peek().equals(a.pop()))
            b.pop();
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }
}