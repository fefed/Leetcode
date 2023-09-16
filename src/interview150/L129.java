package interview150;

import java.util.ArrayDeque;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("all")
public class L129 {
    int sum = 0;

    public int sumNumbers1(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int preSum) {
        if (root == null)
            return;
        int curSum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += curSum;
            return;
        }
        dfs(root.left, curSum);
        dfs(root.right, curSum);
    }

    // BFS解法
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        ArrayDeque<TreeNode> nodeQueue = new ArrayDeque<>();
        ArrayDeque<Integer> numQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);

        Integer sum = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer num = numQueue.poll();
            if (node.left == null && node.right == null)
                sum += num;
            else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    numQueue.offer(num * 10 + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    numQueue.offer(num * 10 + node.right.val);
                }
            }
        }
        return sum;
    }
}
