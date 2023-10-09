package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L108 {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return divide(0, nums.length - 1);
    }

    private TreeNode divide(int left, int right) {
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid == left)
            root.left = null;
        else
            root.left = divide(left, mid - 1);
        if (mid == right)
            root.right = null;
        else
            root.right = divide(mid + 1, right);
        return root;
    }

    // 简洁写法
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
