package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L86 {
    // 模拟，维护两条链表
    public ListNode partition1(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(0, head), largeList = new ListNode(0);
        ListNode iter = dummyHead,  tail = dummyHead, large = largeList;
        while (iter.next != null){
            if (iter.next.val >= x){
                large.next = iter.next;
                iter.next = iter.next.next;
                large = large.next;
            }else {
                iter = iter.next;
                tail = iter;
            }
        }
        large.next = null;
        tail.next = largeList.next;
        return dummyHead.next;
    }

    // 更简洁写法
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode smallHead = new ListNode(0), largeHead = new ListNode(0);
        ListNode small = smallHead, large = largeHead;
        while (head != null){
            if (head.val < x){
                small.next = head;
                small = small.next;
            }else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
