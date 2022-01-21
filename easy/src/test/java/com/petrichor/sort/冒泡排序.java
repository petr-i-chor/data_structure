package com.petrichor.sort;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 16:23 2022/1/20
 */
public class 冒泡排序 {

    @Test
    public void main() {
        int[] arr = {1, 3, 4, 7, 5, 3, 2};
        BubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }

    public void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//取子
            for (int j = 0; j < arr.length - i - 1; j++) { //排序
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
