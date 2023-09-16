package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L19 {
    // 倒数第n个节点，双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode slow = dummyHead, quick = dummyHead;
        // 先走n步
        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }
        while (quick.next !=null){
            slow = slow.next;
            quick = quick.next;
        }
        // 此时，quick指向最后一个节点，slow指向倒数第n个节点的前一个节点
        // 删除倒数第n个节点
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
