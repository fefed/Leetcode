package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L28 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        int[] next = new int[n + 1];
        haystack = " " + haystack;
        needle = " " + needle;

        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && needle.charAt(i) != needle.charAt(j + 1))
                j = next[j];
            if (needle.charAt(i) == needle.charAt(j + 1))
                j++;
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && haystack.charAt(i) != needle.charAt(j + 1))
                j = next[j];
            if (haystack.charAt(i) == needle.charAt(j + 1))
                j++;
            if (j == n)
                return i - n;
        }
        return -1;
    }
}
