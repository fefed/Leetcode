package interview150;

import java.util.HashMap;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L105 {
    // 递归
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (inLeft > inRight)
            return null;
        int val = preorder[preLeft];
        TreeNode cur = new TreeNode(val);
        if (preLeft == preRight) {
            cur.left = null;
            cur.right = null;
            return cur;
        }
        int rootIndex = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                rootIndex = i;
                break;
            }
        }
        cur.left = buildTreeHelper(preorder, inorder, preLeft + 1, preLeft + rootIndex - inLeft, inLeft, rootIndex - 1);
        cur.right = buildTreeHelper(preorder, inorder, preLeft + rootIndex - inLeft + 1, preRight, rootIndex + 1, inRight);
        return cur;
    }

    // 递归+哈希优化
    private final HashMap<Integer, Integer> indexOfValue = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexOfValue.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (inLeft > inRight)
            return null;
        Integer index = indexOfValue.get(preorder[preLeft]);
        TreeNode cur = new TreeNode(preorder[preLeft]);
        int leftNum = index - inLeft;
        cur.left = myBuildTree(preorder, inorder, preLeft + 1, preLeft + leftNum, inLeft, index - 1);
        cur.right = myBuildTree(preorder, inorder, preLeft + leftNum + 1, preRight, index + 1, inRight);
        return cur;
    }
}
