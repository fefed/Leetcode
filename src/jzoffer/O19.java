package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O19 {
    // dp[i][j]表示s的前i个字符和p的前j个字符是否匹配
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 1. 空串+空正则 => 匹配
        dp[0][0] = true;
        // 2. 非空串+空正则 => 不匹配
        // 即. i(1,m),dp[i][0] = false
        // 因为默认初始化为false，不需赋值
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (i > 0 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.'))
                        dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 抛弃 [a-z.]*直接匹配剩下的
                    if (j >= 2)
                        dp[i][j] = dp[i][j - 2];
                    // 匹配[a-z.]*
                    if (i >= 1 && j >= 2 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'))
                        dp[i][j] |= dp[i - 1][j]; // 取或，即抛弃和不抛弃只要又一个匹配成功即可
                }
            }
        }
        return dp[m][n];
    }
}
