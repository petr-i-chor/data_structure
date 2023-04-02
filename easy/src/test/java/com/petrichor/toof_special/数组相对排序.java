package com.petrichor.toof_special;

import org.junit.Test;

/**
 * 剑指 Offer II 075. 数组相对排序
 * 给定两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 */
public class 数组相对排序 {

    @Test
    public void main() {
        int[] nums1 = {2,3,1,3,2,4,6,19,9,2,7};
        int[] nums2 = {2,1,4,3,9,6};
        int[] res = relativeSortArray(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+"\t");
        }
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int cur = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int i1 = 0; i1 < arr1.length; i1++) {
                if (arr1[i1] == arr2[i]){
                    int index = i1;
                    while (index>cur){
                        int tmp = arr1[index];
                        arr1[index]= arr1[index-1];
                        arr1[index-1] = tmp;
                        index--;
                    }
                    cur++;
                }
            }
        }

        for (int i = cur+1; i < arr1.length; i++) {
            int index = i;
            while (index>cur){
                if (arr1[index]<arr1[index-1]){
                    int tmp = arr1[index];
                    arr1[index] = arr1[index-1];
                    arr1[index-1] = tmp;
                    index--;
                }else {
                    break;
                }
            }
        }


        return arr1;
    }
}
