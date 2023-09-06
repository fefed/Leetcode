package interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L228 {
    public List<String> summaryRanges1(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        int start, end;
        int i = 0;
        while (i < nums.length) {
            start = end = nums[i];
            i++;
            while (i < nums.length && end + 1 == nums[i]) {
                end++;
                i++;
            }
            if (start == end)
                res.add(String.valueOf(start));
            else
                res.add(start + "->" + end);
        }
        return res;
    }

    // 另一种写法
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        // i 初始指向第 1 个区间的起始位置
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // j 向后遍历，直到不满足连续递增(即 nums[j] + 1 != nums[j + 1])
            // 或者 j 达到数组边界，则当前连续递增区间 [i, j] 遍历完毕，将其写入结果列表。
            if (j + 1 == nums.length || nums[j] + 1 != nums[j + 1]) {
                // 将当前区间 [i, j] 写入结果列表
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                if (i != j) {
                    sb.append("->").append(nums[j]);
                }
                res.add(sb.toString());
                // 将 i 指向更新为 j + 1，作为下一个区间的起始位置
                i = j + 1;
            }
        }
        return res;
    }
}
