package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return TwoTreeSymmetric(root.left, root.right);
    }
    // 判断两个树是否对称
    // 注意应是A的左子树和B的右子树对称，B的左子树和A的右子树对称
    private boolean TwoTreeSymmetric(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null || node1.val != node2.val) return false;
        return TwoTreeSymmetric(node1.left, node2.right) && TwoTreeSymmetric(node1.right, node2.left);
    }
}
