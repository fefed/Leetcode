package jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O68_2 {
    // 方法一：直觉，暴力dfs，然后对比
    /*
    List<List<TreeNode>> paths = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, new LinkedList<>());
        dfs(root, q, new LinkedList<>());
        List<TreeNode> pathA = paths.get(0);
        List<TreeNode> pathB = paths.get(1);
        int size = Math.min(pathA.size(), pathB.size());
        int i = 0;
        TreeNode res = root;
        while (i < size && pathA.get(i) == pathB.get(i)) {
            res = pathA.get(i);
            i++;
        }
        return res;
    }

    private void dfs(TreeNode cur, TreeNode target, LinkedList<TreeNode> path) {
        if (cur == null) return;
        path.add(cur);
        if (cur.val == target.val) {
            paths.add(new LinkedList<>(path));
            return;
        }
        dfs(cur.left, target, path);
        dfs(cur.right, target, path);
        path.removeLast();
    }
     */

    // 方法二：先序遍历，递归+分治
    // 将找p或q和最近公共祖先结合
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
