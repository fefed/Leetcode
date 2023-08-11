package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O51 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = l + r >> 1;
        int res = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);

        int i = l, j = mid + 1, k = 0;
        int[] tmp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) tmp[k++] = nums[i++];
            else {
                tmp[k++] = nums[j++];
                res += mid - i + 1;
            }
        }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];
        for (int m = l, n = 0; m <= r; m++, n++) {
            nums[m] = tmp[n];
        }
        return res;
    }

    public static void main(String[] args) {
        int pairs = new O51().reversePairs(new int[]{7, 5, 6, 4});
    }
}
