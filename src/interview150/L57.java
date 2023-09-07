package interview150;

import java.util.ArrayList;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        // 新区间[s, t]
        // 寻找满足ti >= s的第一个区间区间[si, ti]
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        // 找不到，说明新区间位于最后面
        if (i == intervals.length) {
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        }
        // 确定合并区间起点
        newInterval[0] = Math.min(intervals[i][0], newInterval[0]);

        while (i < intervals.length && intervals[i][1] <= newInterval[1]) {
            i++;
        }
        if (i == intervals.length) {
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        }
        if (intervals[i][0] <= newInterval[1]) {
            newInterval[1] = intervals[i][1];
            i++;
        }
        res.add(newInterval);

        while (i < intervals.length) {
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
