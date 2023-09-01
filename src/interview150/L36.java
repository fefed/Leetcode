package interview150;

import java.util.Arrays;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L36 {
    // 暴力
    public boolean isValidSudoku1(char[][] board) {
        int[] nums = new int[9];
        // 行检查
        for (char[] row : board) {
            Arrays.fill(nums, 0);
            for (char ele : row) {
                if (ele != '.' && ++nums[ele - '1'] > 1)
                    return false;
            }
        }

        // 列检查
        for (int i = 0; i < 9; i++) {
            Arrays.fill(nums, 0);
            for (int j = 0; j < 9; j++) {
                char ele = board[j][i];
                if (ele != '.' && ++nums[ele - '1'] > 1)
                    return false;
            }
        }


        // 小方块检查
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(nums, 0);
                for (int m = 3 * i; m < 3 * i + 3; m++) {
                    for (int n = 3 * j; n < 3 * j + 3; n++) {
                        char ele = board[m][n];
                        if (ele != '.' && ++nums[ele - '1'] > 1)
                            return false;
                    }
                }
            }
        }
        return true;
    }


    // 一次遍历
    public boolean isValidSudoku(char[][] board) {
        int [][]row  =new int[9][10];
        int [][]col  =new int[9][10];
        int [][]boxes  =new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]=='.'){
                    continue;
                }
                int curNum = board[i][j]-'0';
                if (row[i][curNum]==1){
                    return false;
                }if (col[j][curNum]==1){
                    return false;
                }
                int[] box = boxes[j / 3 + (i / 3) * 3];
                if (box[curNum]==1){
                    return false;
                }
                row[i][curNum]=1;
                col[j][curNum]=1;
                box[curNum]=1;
            }
        }
        return true;
    }
}


