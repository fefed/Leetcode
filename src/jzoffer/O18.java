package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;

        ListNode pre = null, cur = head;
        while(cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }
}
