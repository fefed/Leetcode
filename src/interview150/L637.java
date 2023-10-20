package interview150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("all")
public class L637 {
    // BFS
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Double> avg = new ArrayList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();
                if (cur.left != null)
                    queue.offerLast(cur.left);
                if (cur.right != null)
                    queue.offerLast(cur.right);
                sum += cur.val;
            }
            avg.add(sum / size);
        }
        return avg;
    }
}
