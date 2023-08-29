package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L392 {
    // 双指针，O(m)
    public boolean isSubsequence1(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) return false;

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }
        return i == m;
    }

    // 如果对大量字符串判断是否为子序列
    // 预处理+动态规划
    // dp[i][j]记录i位置之后(包含i)字符j第一次出现的位置
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) return false;

        int[][] dp = new int[n + 1][26];

        // 初始化，dp[i][j]=n表示i之后不包含j字符
        for (int i = 0; i < 26; i++) {
            dp[n][i] = n;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) - 'a' == j)
                    dp[i][j] = i;
                else
                    dp[i][j] = dp[i + 1][j];
            }
        }

        int st = 0;
        for (int i = 0; i < m; i++) {
            int pos = dp[st][s.charAt(i) - 'a'];
            if (pos == n)
                return false;
            st = pos + 1;
        }
        return true;
    }
}
