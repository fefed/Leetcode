package Acwing.a786;

import java.util.Scanner;

/**
 * @author 张东亚
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(finkK(a, 0, n - 1, k));
    }

    public static int finkK(int[] a, int l, int r, int k) {
        if (l >= r) return a[l];

        int x = a[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (a[++i] < x) ;
            while (a[--j] > x) ;
            if(i < j)
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        if (j - l + 1 >= k) return finkK(a, l, j, k);
        else return finkK(a, j + 1, r, k - j + l - 1);
    }
}
