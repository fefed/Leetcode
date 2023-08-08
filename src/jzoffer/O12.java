package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O12 {
    // 方法一：使用标记数组的DFS+剪枝
    boolean[][] access;

    public boolean exist1(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        char[] words = word.toCharArray();
        access = new boolean[row][col];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs1(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs1(char[][] board, int i, int j, char[] word, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || access[i][j] || board[i][j] != word[k])
            return false;
        if (k == word.length - 1) return true;
        access[i][j] = true;
        boolean res = dfs1(board, i + 1, j, word, k + 1) || dfs1(board, i, j + 1, word, k + 1)
                || dfs1(board, i - 1, j, word, k + 1) || dfs1(board, i, j - 1, word, k + 1);
        access[i][j] = false;
        return res;
    }

    // 方法二：使用board本身进行标记的DFS+剪枝
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] word, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '\0' || board[i][j] != word[k])
            return false;
        if (k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, i + 1, j, word, k + 1) || dfs(board, i, j + 1, word, k + 1)
                || dfs(board, i - 1, j, word, k + 1) || dfs(board, i, j - 1, word, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
