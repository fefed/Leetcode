package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
@SuppressWarnings("unused")
public class L452 {
    // 贪心：区间选点/最大不相交区间数
    public int findMinArrowShots(int[][] points) {
        // 在力扣中，使用自定义快排更快
//        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
        quicksort(points, 0, points.length - 1);
        int res = 1, end = points[0][1];
        for (int[] point : points) {
            if (point[0] > end) {
                res++;
                end = point[1];
            }
        }
        return res;
    }

    private void quicksort(int[][] arr, int l, int r) {
        if (l >= r) return;
        int x = arr[l + r >> 1][1], i = l - 1, j = r + 1;
        while (i < j) {
            while (arr[++i][1] < x) ;
            while (arr[--j][1] > x) ;
            if (i < j) {
                int[] tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        quicksort(arr, l, j);
        quicksort(arr, j + 1, r);
    }
}
