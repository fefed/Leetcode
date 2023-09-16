package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L148 {
    // 归并排序
    // 快慢指针确定中点
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 快慢指针，停止时，偶数节点slow指向n/2，奇数节点指向n/2+1
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeSortedList(left, right);
    }


    // 自底向上归并
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;

        // 统计链表长度
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode pre = dummyHead, cur = dummyHead.next;
            while (cur != null) {
                // 截取待合并段1
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }

                if (cur.next == null){
                    pre.next = head1;
                    break;
                }

                ListNode head2 = cur.next;
                cur.next = null;
                // 截取待合并段2
                cur = head2;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }

                ListNode nextHead = cur.next;
                cur.next = null;

                pre.next = mergeSortedList(head1, head2);
                while (pre.next != null)
                    pre = pre.next;

                cur = nextHead;
            }
        }
        return dummyHead.next;
    }

    private ListNode mergeSortedList(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }
}
