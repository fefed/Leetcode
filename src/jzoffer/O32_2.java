package jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O32_2 {
    // 层次遍历并且将每一层打印为1行
    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 存储当前行的数据
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                row.add(node.val);
                // 存入下一层的节点
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(row);
        }
        return res;
    }
}
