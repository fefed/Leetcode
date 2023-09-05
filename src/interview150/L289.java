package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L289 {
    // 暴力，辅助数组
    public void gameOfLife1(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] res = new int[m][n];
        int[] x = {-1, 0, 1};
        int[] y = {-1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0;
                for (int shiftX : x) {
                    for (int shiftY : y) {
                        if (shiftX == 0 && shiftY == 0) continue;
                        int newX = i + shiftX, newY = j + shiftY;
                        if (newX >= 0 && newX < m && newY >= 0 && newY < n && board[newX][newY] == 1)
                            num += 1;
                    }
                }
                if (board[i][j] == 1 && (num == 2 || num == 3))
                    res[i][j] = 1;
                else if (board[i][j] == 0 && num == 3) {
                    res[i][j] = 1;
                } else
                    res[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            System.arraycopy(res[i], 0, board[i], 0, n);
        }
    }

    // 借助复合状态实现原地计算
    public void gameOfLife2(int[][] board) {
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            // 相邻位置的坐标
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // 规则 1 或规则 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }

        // 遍历 board 得到一次更新后的状态
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

    // 借助位运算
    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};

        int rows = board.length, cols = board[0].length;

        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (neighbors[i] != 0 || neighbors[j] != 0) {
                            // 相邻位置的坐标
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0)) {
                                liveNeighbors += board[r][c] & 1;
                            }
                        }
                    }
                }

                // 利用第二位来存储
                if ((board[row][col] == 1) && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    board[row][col] |= 2;
                }
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] |= 2;
                }
            }
        }
        // 右移一位
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] >>>= 1;
            }
        }
    }
}

