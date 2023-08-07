package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O26 {
    /*
    整体思路：遍历A所有节点，判断B是否是【以该节点为起点的子树】的同根子结构
    算法思想：先序遍历，递归，分治
     */
    // 判断B是否是A的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        // B为A的子结构，必为以下情况之一：
        // 1. B为A的同根子结构
        // 2. B是A的左子树的子结构
        // 3. B是A的右子树的子结构
        return isSameRootSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    // 判断B是否是A的【同根】子结构
    private boolean isSameRootSubStructure(TreeNode A, TreeNode B) {
        // B为空，已到叶节点下，OK
        if (B == null) return true;
        // A为空，B不为空，No;节点值不匹配，No
        if (A == null || A.val != B.val) return false;
        // 根节点匹配，继续匹配左右子节点
        return isSameRootSubStructure(A.left, B.left) && isSameRootSubStructure(A.right, B.right);
    }
}
