package jzoffer;

import java.util.ArrayList;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O06 {
//    public int[] reversePrint(ListNode head) {
//        int[] res = new int[10000];
//        int i = 0;
//        while (head != null) {
//            res[i++] = head.val;
//            head = head.next;
//        }
//        int j = 0, k = i - 1;
//        while (j < k) {
//            res[j] ^= res[k];
//            res[k] ^= res[j];
//            res[j] ^= res[k];
//            j++;
//            k--;
//        }
//        return Arrays.copyOfRange(res, 0, i);
//    }
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(res.length - i - 1);
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

