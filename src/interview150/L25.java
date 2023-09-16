package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L25 {
    // 递归
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null)
            return null;
        if (k == 1)
            return head;
        ListNode cur = head;
        int i = 1;
        while (i < k && cur.next != null){
            cur = cur.next;
            i++;
        }
        if (i < k)
            return head;

        ListNode res = cur, nextGroup = cur.next;
        ListNode pre = head;
        cur = head.next;
        while (cur != nextGroup){
            // 反转
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup1(nextGroup, k);
        return res;
    }


    // 非递归，原地解决
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        if (k == 1)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            ListNode start = cur;
            int i = 1;
            while (i < k && cur.next != null)
            {
                cur = cur.next;
                i++;
            }
            if (i < k){
                pre.next = start;
                break;
            }

            ListNode next = cur.next;
            cur.next = null;

            pre.next = reverse(start);
            pre = start;

            cur = next;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
