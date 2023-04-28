package com.petrichor.golden;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 9:14 2023/4/28
 */
public class 合并排序数组 {

    @Test
    public void main() {
        int[] A = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] B = {1, 2, 3};
        int n = 3;
        merge(A, m, B, n);
        System.out.println();
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int a = m - 1;
        int b = n - 1;
        int index = m + n - 1;
        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[index] = A[a];
                a--;
                index--;
            } else {
                A[index] = B[b];
                b--;
                index--;
            }
        }
        for (int i = 0; i <= b; i++) {
            A[i] = B[i];
        }
    }
}
