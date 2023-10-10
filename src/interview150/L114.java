package interview150;

import java.util.ArrayDeque;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L114 {
    // 方法一：模拟
    // 将左子树插入到右子树的地方
    // 将原来的右子树接到左子树的最右边节点
    // 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
    public void flatten1(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                // 寻找左子树的最右子节点
                TreeNode tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                // 最右子节点右接右子树
                tmp.right = root.right;
                // 根节点右接左子树
                root.right = root.left;
                // 左子树置空
                root.left = null;
            }
            root = root.right;
        }
    }

    // 方法二：先序遍历（带栈）
    // 先序遍历，每遍历到一个节点，将上一个节点的右侧指针指向当前节点
    // 注意，直接指向会导致上一个节点的右子树丢失，所以用栈进行保存
    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        TreeNode pre = null;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (pre != null) {
                pre.left = null;
                pre.right = cur;
            }
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
            pre = cur;
        }
    }

    // 最简洁
    // 方法三：后序遍历
    // 后序遍历递归写法，遍历到一个节点就将其右指针指向前一个节点
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
