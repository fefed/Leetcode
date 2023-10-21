package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L236 {
    // root 等于 p 或 q，最近公共祖先为 root
    // p 和 q 分列 root 两侧，最近公共祖先为 root
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 首先检查根节点是否为空或者等于 p 或 q，如果是，则返回根节点本身，因为根节点本身就是它们的共同祖先。
        if (root == null | root == p || root == q)
            return root;
        // 递归调用 lowestCommonAncestor 函数来查找左子树中 p 和 q 的最低共同祖先，将结果赋值给变量 left。
        // 递归调用 lowestCommonAncestor 函数来查找右子树中 p 和 q 的最低共同祖先，将结果赋值给变量 right。
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果 left 为 null，说明 p 和 q 的最低共同祖先在右子树中，直接返回 right。
        // 如果 right 为 null，说明 p 和 q 的最低共同祖先在左子树中，直接返回 left。
        if (left == null) return right;
        if (right == null) return left;
        // 如果以上情况都不满足，说明 p 和 q 分别位于当前节点的左右子树中，当前节点即为它们的最低共同祖先，返回 root
        return root;
    }
}
