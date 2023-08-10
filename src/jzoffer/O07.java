package jzoffer;

import java.util.HashMap;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O07 {
    // 方法一：坐标由遍历求得

//    int[] preOrder, inOrder;
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        preOrder = preorder;
//        inOrder = inorder;
//        return buildTreeHelper(0, 0, preorder.length - 1);
//    }
//
//
//    /**
//     *
//     * @param root 在前序遍历中的第一个元素的坐标
//     * @param start 在中序遍历中的开始坐标
//     * @param end 在中序遍历中的结束坐标
//     * @return 利用start-end中节点构建出的二叉树
//     */
//    private TreeNode buildTreeHelper(int root, int start, int end) {
//        if (start > end) return null;
//        TreeNode cur = new TreeNode(preOrder[root]);
//        int rootIndex = 0;
//        for (int i = start; i <= end; i++) {
//            if (inOrder[i] == preOrder[root]) {
//                rootIndex = i;
//                break;
//            }
//        }
//        cur.left = buildTreeHelper(root + 1, start, rootIndex - 1);
//        cur.right = buildTreeHelper(root + rootIndex - start + 1, rootIndex + 1, end);
//        return cur;
//    }

    // 方法二：借助map存储中序元素和下标的对应关系
    int[] preOrder;
    HashMap<Integer, Integer> inOrderIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndex.put(inorder[i], i);
        }
        return buildTreeHelper(0, 0, preorder.length - 1);
    }

    private TreeNode buildTreeHelper(int root, int left, int right) {
        if (left > right) return null;
        TreeNode cur = new TreeNode(preOrder[root]);
        int rootIndex = inOrderIndex.get(preOrder[root]);
        cur.left = buildTreeHelper(root + 1, left, rootIndex - 1);
        cur.right = buildTreeHelper(root + rootIndex - left + 1, rootIndex + 1, right);
        return cur;
    }


    public static void main(String[] args) {
        TreeNode res = new O07().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
