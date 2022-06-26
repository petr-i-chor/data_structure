package com.petrichor.sort;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 10:29 2022/1/21
 */
public class 插入排序 {

    @Test
    public void main() {
        int[] arr = {1, 3, 4, 7, 5, 3, 2};
        InsertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }

    public void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (arr[j]>=arr[j-1])
                    break;
                else {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
            for (int ii = 0; ii < arr.length; ii++) {
                System.out.print(arr[ii]+"\t");
            }
            System.out.println();
        }

    }
}

