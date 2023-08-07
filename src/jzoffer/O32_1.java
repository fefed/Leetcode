package jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O32_1 {
    // 层次序遍历，借助队列
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];

        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

