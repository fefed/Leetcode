package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O27 {
    // 二叉树的镜像
    // 递归，子树镜像，然后镜像子树
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode rightNode = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = rightNode;
        return root;
    }
}
