package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O68_1 {

    // 方法一：递归，1.都在左子树且非左儿子；2.都在右子树且非右儿子；3.当前就是最近祖先
    // 时间：O(N) 空间：最坏O(N)
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor1(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor1(root.right, p, q);
        return root;
    }

    // 方法二：迭代
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            if (p.val > root.val && q.val > root.val)
                root = root.right;
            else break;
        }
        return root;
    }

    // 方法三：迭代法改进
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 设定p和q的大小关系，简化后面的判断条件
        // 此时设定p.val <= q.val
        if (p.val > q.val){
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (root != null) {
            if (q.val < root.val)
                root = root.left;
            else if (p.val > root.val)
                root = root.right;
            else break;
        }
        return root;
    }
}
