package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O13 {
    // 标记数组
    private boolean[][] isVisited;
    public int movingCount(int m, int n, int k) {
        isVisited = new boolean[m][n];
        return bfs(m, n, k, 0, 0);
    }

    // BFS：向右向下搜索
    private int bfs(int m, int n, int k, int i, int j) {
        // 搜到头或搜索过，返回0
        if (i >= m || j >= n || isVisited[i][j]) return 0;
        // 数位和 > k 返回0
        int digitSum = i / 100 + (i / 10) % 10 + i % 10 + j / 100 + (j / 10) % 10 + j % 10;
        if (digitSum > k)
            return 0;
        isVisited[i][j] = true;
        return bfs(m, n, k, i + 1, j) + bfs(m, n, k, i, j + 1) + 1;
    }
}
