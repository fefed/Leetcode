package interview150;

import java.util.Arrays;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L274 {
    // 直觉做法：时间：O(nlgn)；空间O(lgn)
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int i = 0, n = citations.length;
        while (i < n && citations[n - 1 - i] >= i + 1) {
            i++;
        }
        return i;
    }

    // 计数排序：时间：O(n)；空间：O(n)
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counter = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                counter[n]++;
            }else
                counter[citation]++;
        }

        int cnt = 0;
        for (int i = n; i >= 0; i--) {
            cnt += counter[i];
            if (cnt >= i)
                return i;
        }
        return 0;
    }

}
