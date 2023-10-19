package interview150;

import java.util.ArrayDeque;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L173 {

}
@SuppressWarnings("all")
class BSTIterator {
    /*
    // 方法一：中序递归遍历一遍
    // 模仿“二叉树展开位为链表”一题的思路，将二叉树利用右指针展开为链表
    // 其他思路：利用列表保存中序遍历值
    TreeNode head = new TreeNode(Integer.MIN_VALUE);
    TreeNode pre;
    public BSTIterator(TreeNode root) {
        pre = head;
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        pre.right = root;
        pre = pre.right;
        inorder(root.right);
    }

    public int next() {
        head = head.right;
        return head.val;
    }

    public boolean hasNext() {
        return head.right != null;
    }

     */

    // 方法二：迭代，单调栈
    // next方法调用时计算
    ArrayDeque<TreeNode> stack;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        cur = root;
    }
    public int next() {
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode pop = stack.pop();
        cur = pop.right;
        return pop.val;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
