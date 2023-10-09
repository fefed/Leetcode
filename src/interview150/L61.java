package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L61 {
    // 直觉做法
    public ListNode rotateRight1(ListNode head, int k) {
        // 链表长度≤1 或 k为0，直接返回
        if (head == null || k == 0)
            return head;
        // 统计链表长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // k取模
        k = k % len;
        if (k == 0)
            return head;
        // 双指针，快指针前移k步
        ListNode fast = head, slow = head;
        while (k != 0) {
            fast = fast.next;
            k--;
        }
        // 同步前进至快指针到达末尾
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 拼接新链表
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

    // 闭合为环
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int len = 1;
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
            len++;
        }
        k = len - k % len;
        if (k == len)
            return head;
        tail.next = head;

        ListNode newTail = head;
        for (int i = 0; i < k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
