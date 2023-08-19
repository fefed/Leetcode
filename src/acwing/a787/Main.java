package acwing.a787;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 张东亚
 * @version 1.0
 */
public class Main {
    private static final int N = 100010;
    private static final int[] q = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        String[] nums = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            q[i] = Integer.parseInt(nums[i]);
        }
        mergeSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(q[i] + " ");
        }
    }

    private static void mergeSort(int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);

        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while(i <= mid && j <= r)
        {
            if(q[i] < q[j]) temp[k++] = q[i++];
            else temp[k++]=q[j++];
        }
        while (i <= mid) temp[k++]=q[i++];
        while (j<=r) temp[k++]=q[j++];
        for (int m = l, n = 0; m <= r; m ++, n ++) {
            q[m]=temp[n];
        }
    }
}
