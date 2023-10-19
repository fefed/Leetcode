package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L124 {
    /*
    区分两种路径和
    1. 子树所能对外提供的最大路径和
        子树能给父节点提供的“价值”，子树路径构成外部路径的一部分
        1).子树根节点值
        2).子树根节点值+其左子树对外最大路径和
        3).子树根节点值+其右子树对外最大路径和
        总结：root.val+max(0, dfs(root.left), dfs(root.right))
    2. 子树內部最大路径和
        子树內部包含根节点的路径的最大路径和，根节点值+左子树所能对外提供的最大路径和+右子树所能对外提供的最大路径和
        dfs(root.left)+root.val+dfs(root.right)
    所以，dfs递归遍历每个节点，计算其內部最大路径和，“挑战”更新最大路径和
     */
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    /**
     * 递归函数，计算以当前节点为根节点的子树的最大路径和
     * @param root 当前节点
     * @return 以当前节点为根节点的子树对外提供的最大路径和
     */
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        int internalMaxSum = root.val + leftSum + rightSum;
        if (internalMaxSum > maxSum)
            maxSum = internalMaxSum;

        int outMaxSum = root.val + Math.max(0, Math.max(leftSum, rightSum));
        return Math.max(outMaxSum, 0);
    }
}
