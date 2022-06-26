package com.petrichor.sort;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 11:23 2022/1/21
 */
public class 归并排序 {

    @Test
    public void main() {
        int[] arr = {1, 3, 4, 7, 5, 3, 2};
        MergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public void MergeSort(int[] arr) {

        int divided = arr.length >> 2;
        int left = 0;
        int right = arr.length - 1;

        //假设 arr[left] 到arr[devided] 是有序数组 ，假设 arr[devided] 到 arr[right] 是有序数组


    }

    /**
     * 合并两个有序数组
     */

    @Test
    public void merge() {
        int[] l = {2, 3, 5, 6, 7};
        int[] r = {1, 4, 5, 6, 8};
        int[] arr = mergeArray(l, r);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public int[] mergeArray(int[] l, int[] r) {
        int[] result = new int[r.length + l.length];
        int left = 0;
        int right = 0;

        for (int i = 0; i < result.length; i++) {
            if (l[left] > r[right]) {
                result[i] = r[right++];
            } else {
                result[i] = l[left++];
            }
            if (left == l.length) {
                for (int j = i + 1; j < result.length; j++) {
                    result[j] = r[right++];
                }
                break;
            }
            if (right == l.length) {
                for (int j = i; j < result.length; j++) {
                    result[j] = l[left++];
                }
                break;
            }
        }
        return result;
    }


    @Test
    public void merge2() {
        int[] arr = {2, 3, 5, 6, 7, 1, 4, 5, 6, 8};
        int[] result = mergeArray2(arr,0,arr.length);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }

    public int[] mergeArray2(int[] arr,int left , int right) {
        int mid = (right + left)>>1;

        int[] cache = new int[arr.length];

        //将arr截取复制到新数组，arr被截取的部分当空数组处理,保证了全程原数组只有值的移动而没有长度的变化
        for (int i = 0; i < arr.length; i++) {
            cache[i] = arr [i];
        }

        for (int i = 0; i < arr.length; i++) {
            if (cache[left]>cache[mid]){
                arr[i] = cache[mid];
                mid++;
            }else {
                arr[i] = cache[left];
                left++;
            }
            if (left == arr.length>>1) {
                for (int j = i + 1; j < cache.length; j++) {
                    arr[j] = cache[mid++];
                }
                break;
            }
            if (mid == cache.length) {
                for (int j = i; j < cache.length; j++) {
                    arr[j] = cache[left++];
                }
                break;
            }

        }
        return arr;
    }


    @Test
    public void test(){
        int[] array = {1, 3, 4, 7, 5, 3, 2};
        mergeSort(array,0,array.length>>1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public void mergeSort(int[] array,int left,int right){
        if (left >= right){
            return;
        }

        mergeSort(array,left,right>>1);
        mergeSort(array,(left+right)>>1+1,right);
        mergeArray2(array,left,right);

    }


}
