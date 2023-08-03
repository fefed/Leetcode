package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 若两者之一为空，直接返回另一个
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // 创建结果链表的头节点
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        // 双指针扫描双链表
        while (l1 != null && l2 != null) {
            // 将较小的节点加入结果链表
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 将剩余节点接续到结果链表尾部
        cur.next = (l1 != null) ? l1 : l2;
        return res.next;
    }
}
