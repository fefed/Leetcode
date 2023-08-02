package jzoffer;

import java.util.HashMap;
import java.util.Set;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O35 {
    // 方法一
    /*
    public Node copyRandomList(Node head) {
        Node tmp = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (head != null) {
            map.put(head, new Node(head.val));
            head = head.next;
        }

        Set<Node> nodes = map.keySet();
        for (Node node : nodes) {
            Node next = node.next;
            Node rand = node.random;
            map.get(node).next = map.get(next);
            map.get(node).random = map.get(rand);
        }
        return map.get(tmp);
    }
    */
    public Node copyRandomList(Node head) {
        Node cur = head;
        // 复制节点
        while (cur != null) {
            Node son = new Node(cur.val); // 新节点
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
        Node pre = head, res = head.next;
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
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}