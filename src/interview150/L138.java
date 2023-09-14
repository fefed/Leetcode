package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 复制链表val和next
        Node oldNode = head;
        while (oldNode != null) {
            Node tmp = new Node(oldNode.val);
            tmp.next = oldNode.next;
            oldNode.next = tmp;
            oldNode = tmp.next;
        }

        // 复制random
        oldNode = head;
        Node newNode;
        while (oldNode != null) {
            newNode = oldNode.next;
            newNode.random = oldNode.random == null ? null : oldNode.random.next;
            oldNode = newNode.next;
        }

        // 取出复制链
        // 恢复原链
        Node res = head.next;
        oldNode = head;
        newNode = head.next;
        while (newNode.next != null){
            oldNode.next = newNode.next;
            oldNode = oldNode.next;
            newNode.next = oldNode.next;
            newNode = newNode.next;
        }
        oldNode.next = null;
        return res;
    }
}

