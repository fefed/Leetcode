package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        // 定义四方边界
        int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        int index = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        // 顺时针遍历，不断缩小边界，当边界相遇，遍历结束
        while (true) {
            // 从左向右
            for (int i = left; i <= right; i ++) res[index++] = matrix[top][i];
            if (++top > bottom) break;
            // 从上向下
            for (int i = top; i <= bottom; i ++) res[index++] = matrix[i][right];
            if (--right < left) break;
            // 从右向左
            for (int i = right; i >= left; i --) res[index++] = matrix[bottom][i];
            if (--bottom < top) break;
            // 从下向上
            for (int i = bottom; i >= top; i --) res[index++] = matrix[i][left];
            if (++left > right) break;
        }
        return res;
    }
}

