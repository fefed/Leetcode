package interview150;

import java.util.HashSet;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L141 {
    // 哈希表
    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null){
            if (!set.add(head))
                return true;
            head = head.next;
        }
        return false;
    }

    // 快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
