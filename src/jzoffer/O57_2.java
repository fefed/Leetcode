package jzoffer;

import java.util.ArrayList;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O57_2 {
    // 滑动窗口
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> res = new ArrayList<>();
        // 窗口[i,j)
        int i = 1, j = 1, sum = 0;
        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            }
            else {
                int[] seq = new int[j - i];
                for (int k = 0; k < j - i; k++)
                    seq[k] = k + i;
                res.add(seq);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] continuousSequence = new O57_2().findContinuousSequence(9);
    }
}
