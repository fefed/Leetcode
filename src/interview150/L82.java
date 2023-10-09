package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L82 {
    // 方法一
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead, cur = dummyHead.next;
        while (cur != null) {
            boolean eq = false;
            while (cur.next != null && cur.next.val == cur.val) {
                eq = true;
                cur = cur.next;
                pre.next = cur;
            }
            if (eq)
                pre.next = cur.next;
            else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }

    // 方法二 思想相同，遍历并删除重复
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }

            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
