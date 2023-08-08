package jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O34 {
    List<List<Integer>> res = new ArrayList<>();
    // 搜索路径
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return res;
        dfs(root, target,0);
        return res;
    }

    // sum是当前路径和
    private void dfs(TreeNode root, int target, int sum) {
        // 将当前点加入路径
        path.add(root.val);
        // 更新路径和
        sum += root.val;
        // 满足条件，加入路径集合
        if (root.left == null && root.right == null && sum == target)
                res.add(new LinkedList<>(path));
        // 左子树不为空，继续探索
        if (root.left != null)
            dfs(root.left, target, sum);
        // 右子树不为空，继续探索
        if (root.right != null)
            dfs(root.right, target, sum);
        // 恢复现场
        path.removeLast();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}