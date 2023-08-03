package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // a + c + b 和 b + c + a 必将相遇
        ListNode lA = headA, lB= headB;
        while (lA != lB) {
            lA = lA == null ? headB : lA.next;
            lB = lB == null ? headA : lB.next;
        }
        return lA;
    }
}
