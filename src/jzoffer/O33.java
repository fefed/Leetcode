package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O33 {
    int[] postOrder;
    public boolean verifyPostorder(int[] postorder) {
        postOrder = postorder;
        return isPostOrder(0, postorder.length - 1);
    }

    private boolean isPostOrder(int left, int right) {
        if (left >= right) return true;
        int root = postOrder[right];
        int lRoot = right - 1;
        while (lRoot >= left) {
            if (postOrder[lRoot] < root) {
                break;
            }
            lRoot--;
        }

        for (int i = lRoot; i >= left; i--)
        {
            if (postOrder[i] > root)
                return false;
        }
        return isPostOrder(left, lRoot) && isPostOrder(lRoot + 1, right - 1);
    }

    // 更简洁
    private boolean isPostOrder1(int left, int right) {
        if (left >= right) return true;

        int p  = left;
        while (postOrder[p] < postOrder[right]) p++;
        int divide = p;
        while (postOrder[p] > postOrder[right]) p++;
        return p == right && isPostOrder(left, divide - 1) && isPostOrder(divide, right - 1);
    }

    public static void main(String[] args) {
        new O33().verifyPostorder(new int[]{5, 4, 3, 2, 1});
    }
}
