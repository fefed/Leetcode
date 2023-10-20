package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L222 {
    // 方法一: 遍历
    // O(n)
    public int countNodes1(TreeNode root) {
        if (root == null)
            return 0;
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }


    // 方法二：按照左右子树长度对比二分+位运算
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        if (leftLevel == rightLevel) {
            return countNodes(root.right) + (1 << leftLevel);
        } else
            return countNodes(root.left) + (1 << rightLevel);
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}
