package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O36 {
    // 代码很简单，理解很费劲
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inOrderTraversal(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    // 中序遍历，将节点与前节点串联为链表
    private void inOrderTraversal(Node cur) {
        if (cur == null) return;
        inOrderTraversal(cur.left);
        if (pre == null)
            head = cur;
        else
            pre.right = cur;
        cur.left = pre;
        pre = cur;
        inOrderTraversal(cur.right);
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}