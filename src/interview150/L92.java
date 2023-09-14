package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L92 {
    // 迭代
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if (left >= right) return head;
        // 添加附加头节点，简化left = 1的情况
        ListNode newHead = new ListNode();
        newHead.next = head;

        ListNode cur = newHead;
        // i指示cur之前的元素数目(包含cur)
        int i = 1;
        while (i < left){
            cur = cur.next;
            i++;
        }
        // 记录left-1位置
        ListNode leftLeft = cur;
        ListNode pre = cur.next;
        cur = pre.next;
        i += 2;
        // 翻转
        while (i <= right){
            ListNode tmp = pre;
            pre = cur;
            cur = cur.next;
            pre.next = tmp;
            i++;
        }
        // 此时，cur指向right所在位置
        // 重链接调整顺序
        leftLeft.next.next = cur.next;

        cur.next = pre;

        leftLeft.next = cur;

        return newHead.next;
    }

    // 简洁迭代：删除+头插法
    public ListNode reverseBetween2(ListNode head, int left, int right) {

        // 添加附加头节点，简化left = 1的情况
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode guard = dummyHead;
        ListNode point = dummyHead.next;

        // guard指向left-1,point指向left
        for (int i = 1; i < left; i++) {
            guard = guard.next;
            point = point.next;
        }

        // [left+1,right]之间的元素，删除加头插法
        for (int i = 0; i < right - left; i++) {
            ListNode removed = point.next;
            // 删除
            point.next = removed.next;
            // 头插法
            removed.next = guard.next;
            guard.next = removed;
        }

        return dummyHead.next;
    }


    // 递归实现
    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
}
