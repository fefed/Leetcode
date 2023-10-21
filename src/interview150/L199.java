package interview150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("all")
public class L199 {
    // 层次序遍历
    public List<Integer> rightSideView1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            res.add(queue.peekLast().val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();
                if (cur.left != null)
                    queue.offerLast(cur.left);
                if (cur.right != null)
                    queue.offerLast(cur.right);
            }
        }
        return res;
    }

    // dfs：按照根-右-左的顺序遍历，每一层最先访问到的是最靠右的节点
    private final List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, Integer depth) {
        if (root == null)
            return;
        // 第一次访问该层，该节点为最右节点，记录
        if (res.size() == depth)
            res.add(root.val);
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}
