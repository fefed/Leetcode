package Acwing.a785;

import java.util.Scanner;

/**
 * @author 张东亚
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        quickSort(a, 0, n - 1);
        for (int elem : a) {
            System.out.print(elem + " ");
        }
    }

    private static void quickSort(int[] a, int l, int r) {
        if (l >= r) return;

        int x = a[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (a[++i] < x) ;
            while (a[--j] > x) ;
            if (i < j) {
                a[i] = a[i] ^ a[j];
                a[j] = a[i] ^ a[j];
                a[i] = a[i] ^ a[j];
            }
        }
        quickSort(a, l, j);
        quickSort(a, j + 1, r);
    }
}
