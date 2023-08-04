package jzoffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 张东亚
 * @version 1.0
 */
// Stack实现
/*
class CQueue {
    Stack<Integer> a;
    Stack<Integer> b;
    public CQueue() {
        a = new Stack<Integer>();
        b = new Stack<Integer>();
    }

    public void appendTail(int value) {
        a.push(value);
    }

    public int deleteHead() {
        if (!b.empty()) {
            return b.pop();
        }
        if (!a.empty()) {
            while (!a.empty()) {
                b.push(a.pop());
            }
            return b.pop();
        }
        return -1;
    }
}
*/
// LinkedList更快些
class CQueue {
    LinkedList<Integer> A, B;
    public CQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }
    public void appendTail(int value) {
        A.addLast(value);
    }
    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}
