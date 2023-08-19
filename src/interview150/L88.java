package interview150;

/**
 * @author 张东亚
 * @version 1.0
 */
public class L88 {
    // 原始做法：双指针+额外数组
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) tmp[k++] = nums1[i++];
            else tmp[k++] = nums2[j++];
        }
        while (i < m) tmp[k++] = nums1[i++];
        while (j < n) tmp[k++] = nums2[j++];
        System.arraycopy(tmp, 0, nums1, 0, m + n);
    }
    // 改进做法：逆向双指针，空间复杂度O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while (j >= 0)
            nums1[k--] = nums2[j--];
    }
}
