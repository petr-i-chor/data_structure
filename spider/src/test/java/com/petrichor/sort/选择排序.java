package com.petrichor.sort;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 10:06 2022/1/21
 */
public class 选择排序 {

    @Test
    public void main() {
        int[] arr = {2, 3, 4, 5, 7, 3, 1};
        SelectionSort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+"\t");
//        }
    }

    public void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) { //插入的位置
            int minIndex = i ;
            for (int j = i; j < arr.length; j++) {  //遍历选择最小
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            for (int ii = 0; ii < arr.length; ii++) {
                System.out.print(arr[ii] + "\t");
            }
            System.out.println();
        }



    }

}
