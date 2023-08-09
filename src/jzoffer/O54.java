package jzoffer;

import java.util.ArrayList;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O54 {
    /*
    // 方法一：中序遍历，存储数据，返回序号为size-k的数据
    ArrayList<Integer> values = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        inOrderTraversal(root);
        return values.get(values.size() - k);
    }
    private void inOrderTraversal(TreeNode cur) {
        if (cur == null) return;
        inOrderTraversal(cur.left);
        values.add(cur.val);
        inOrderTraversal(cur.right);
    }
     */
    // 方法二：中序遍历倒序，遍历到第k个即提前终止
    int res, order;

    public int kthLargest(TreeNode root, int k) {
        order = k;
        inOrderTraversal(root);
        return res;
    }
    private void inOrderTraversal(TreeNode cur) {
        if (cur == null) return;
        // 先右后左
        inOrderTraversal(cur.right);
        // 到第k个则终止
        if (--order == 0) {
            res = cur.val;
            return;
        }
        inOrderTraversal(cur.left);
    }
}
