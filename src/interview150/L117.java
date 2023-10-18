package interview150;

import java.util.ArrayDeque;

import interview150.nodes.Node;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("all")
public class L117 {
    // 方法一：BFS
    public Node connect1(Node root) {
        if (root == null)
            return null;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            // 该层节点数量
            int num = queue.size();
            // 取出该层第一个点
            Node pre = queue.pollFirst();
            if (pre.left != null)
                queue.offerLast(pre.left);
            if (pre.right != null)
                queue.offerLast(pre.right);
            // 依次取出剩余节点，并串联
            for (int i = 0; i < num - 1; i++) {
                Node cur = queue.pollFirst();
                if (cur.left != null)
                    queue.offerLast(cur.left);
                if (cur.right != null)
                    queue.offerLast(cur.right);
                pre.next = cur;
                pre = cur;
            }
        }
        return root;
    }

    // 方法二：链表串联，不用队列
    public Node connect(Node root) {
        if (root == null)
            return null;
        Node cur = root;
        while (cur != null) {
            // 构建下一层链表的头节点
            Node dummyHead = new Node(0);
            Node pre = dummyHead;
            // 遍历当前层链表节点
            while (cur != null) {
                // 左孩子不为空，串联到链表上
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                // 右孩子不为空，串联到链表上
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                // 移动到下一节点
                cur = cur.next;
            }
            // 当前层遍历完毕，转移到下一层节点链表
            cur = dummyHead.next;
        }
        return root;
    }
}
