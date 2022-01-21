package com.petrichor.sort;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 16:53 2022/1/20
 */
public class 快速排序 {

    @Test
    public void main() {
        int[] arr = {1, 3, 4, 7, 5, 3, 2};
//        int[] arr = {5,7,4};
        QuickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public void QuickSort(int[] arr, int l, int r) {

        int left = l;
        int right = r;

        if (left >= right){
            return;
        }

        int pivot = arr[left];

        while (left < right) {


            while (arr[right] > pivot && left < right) {
                right--;
            }

            if (left < right){
                arr[left] = arr[right];
            }

            while (arr[left] <= pivot && left < right) {
                left++;
            }

            if (left < right){
                arr[right] = arr [left];
            }

        }

        arr[right] = pivot;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();

        QuickSort(arr,l,left-1);
        QuickSort(arr,right+1,r);

    }
}
