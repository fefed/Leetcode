package interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L54 {
    // 螺旋矩阵：模拟
    public List<Integer> spiralOrder1(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, up = 0, bottom = matrix.length - 1;
        while (left <= right && up <= bottom) {
            for (int i = left; i <= right; i++)
                res.add(matrix[up][i]);
            if (++up > bottom) break;
            for (int i = up; i <= bottom; i++)
                res.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--)
                res.add(matrix[bottom][i]);
            if (--bottom < up) break;
            for (int i = bottom; i >= up; i--)
                res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }
}
