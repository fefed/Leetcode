package jzoffer;

import java.util.LinkedList;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O55_1 {
    // 方法一：直接分治递归,DFS
    /*
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
     */

    // 方法二：BFS
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int res = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            res++;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
}
