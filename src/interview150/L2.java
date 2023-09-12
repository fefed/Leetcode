package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode res = new ListNode();
        ListNode cur = res;
        int proDigit = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + proDigit;
            proDigit = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = l1 == null ? l2 : l1;
        while (remain != null) {
            if (proDigit == 0) {
                cur.next = remain;
                break;
            }
            int sum = remain.val + proDigit;
            proDigit = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            remain = remain.next;
        }
        if (proDigit == 1)
            cur.next = new ListNode(1);
        return res.next;
    }
}
