package jzoffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null,";
        StringBuilder res = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp != null){
                res.append(tmp.val).append(",");
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }else {
                res.append("null,");
            }
        }
        // 保留最后一个','，反序列化注意即可
        return res.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        if ("null".equals(values[0])) return null;

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(values[i])) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            i++;
            if (!"null".equals(values[i])) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        O37 test = new O37();
        test.serialize(test.deserialize("1,2,3,null,null,4,5,null,null,null,null"));
    }
}
