package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O55_2 {
    // 方法一：从下到上，分支+深度计算
    // 存在深度的重复计算
    /*
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
     */

    // 方法二：后序遍历+剪枝
    public boolean isBalanced(TreeNode root) {
        return advancedDepth(root) != -1;
    }

    // 如果不平衡，返回-1
    private int advancedDepth(TreeNode node) {
        if (node == null) return 0;
        int lDepth = advancedDepth(node.left);
        if (lDepth == -1) return -1;
        int rDepth = advancedDepth(node.right);
        if (rDepth == -1) return -1;
        return Math.abs(lDepth - rDepth) <= 1 ? Math.max(lDepth, rDepth) + 1 : -1;
    }
}
