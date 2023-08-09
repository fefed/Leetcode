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
    // 1. 若树里面存在p，也存在q，则返回他们的公共祖先。
    // 2. 若树里面只存在p，或只存在q，则返回存在的那一个。
    // 3. 若树里面既不存在p，也不存在q，则返回null。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
