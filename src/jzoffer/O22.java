package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O22 {
    // 解法一 哈希表
    /*
    public ListNode getKthFromEnd(ListNode head, int k) {
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        int num = 0;
        while(head != null) {
            map.put(++num, head);
            head = head.next;
        }
        return map.get(num - k + 1);
    }
     */
    // 解法二 双指针法
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        while (k-- > 0)
            former = former.next;
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
