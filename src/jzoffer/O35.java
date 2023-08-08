package jzoffer;

import java.util.HashMap;
import java.util.Set;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O35 {
    // 方法一
    public Node35 copyRandomList1(Node35 head) {
        Node35 tmp = head;
        HashMap<Node35, Node35> map = new HashMap<>();
        while (head != null) {
            map.put(head, new Node35(head.val));
            head = head.next;
        }

        Set<Node35> nodes = map.keySet();
        for (Node35 node : nodes) {
            Node35 next = node.next;
            Node35 rand = node.random;
            map.get(node).next = map.get(next);
            map.get(node).random = map.get(rand);
        }
        return map.get(tmp);
    }
    public Node35 copyRandomList(Node35 head) {
        Node35 cur = head;
        // 复制节点
        while (cur != null) {
            Node35 son = new Node35(cur.val); // 新节点
            son.next = cur.next; // 插入旧节点后
            cur.next = son;
            cur = son.next; // 移向下一个旧节点
        }

        // 复制random指针
        cur = head;
        while(cur != null) {
            cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        // 拆分链表
        Node35 pre = head, res = head.next;
        cur = head.next;
        while(cur.next != null) {
            pre.next = cur.next;
            cur.next = pre.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }
}


// Definition for a Node.
class Node35 {
    int val;
    Node35 next;
    Node35 random;

    public Node35(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}