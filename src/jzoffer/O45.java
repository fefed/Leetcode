package jzoffer;

/**
 * @author 张东亚
 * @version 1.0
 */
public class O45 {
    public String minNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            res.append(num);
        }
        return res.toString();
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int i = left - 1, j = right + 1;
        int x = nums[left + right >> 1];
        while (i < j) {
            while (biggerThan(x, nums[++i]) > 0) ;
            while (biggerThan(nums[--j], x) > 0) ;
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }

    private int biggerThan(int x1, int x2) {
        String str1 = x1 + "" + x2;
        String str2 = x2 + "" + x1;
        return str1.compareTo(str2);
    }

    // 方法二：更简洁
    public String minNumber1(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
    void quickSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }

    public static void main(String[] args) {
        O45 o45 = new O45();
        String res = o45.minNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247});
        System.out.println(res);
    }
}
