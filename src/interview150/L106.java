package interview150;

import java.util.HashMap;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L106 {
    // 递归+哈希
    private HashMap<Integer, Integer> indexOfValue;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexOfValue = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexOfValue.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight)
            return null;
        Integer index = indexOfValue.get(postorder[postRight]);
        TreeNode cur = new TreeNode(postorder[postRight]);
        int numLeft = index - inLeft;
        cur.left = myBuildTree(inorder, postorder, inLeft, index - 1, postLeft, postLeft + numLeft - 1);
        cur.right = myBuildTree(inorder, postorder, index + 1, inRight, postLeft + numLeft, postRight - 1);
        return cur;
    }
}
