package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 选定左下角为开始点，构成一棵 “二叉搜索树”
        int i = matrix.length - 1, j = 0;
        // 每次根据比较结果，若未找到，舍弃一行或一列
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        // 未找到
        return false;
    }
}
