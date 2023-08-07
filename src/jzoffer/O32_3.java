package jzoffer;

import java.util.*;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        // 反转标志，判断当前层是否需要反转
        boolean reverse = false;

        while (!queue.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            // 如果偶数层，需要取反
            if (reverse) Collections.reverse(tmp);
            res.add(tmp);
            // 标志取反
            reverse = !reverse;
        }
        return res;
    }
}
