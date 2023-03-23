package com.petrichor.reviewSort;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 14:18 2023/3/17
 */
public class 归并排序 {

    @Test
    public void main() {
        int[] nums = {13, 2, 32, 5, 7, 3, 71, 8, 2, 12, 421, 43, 1};
        mergeSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }

    public void mergeSort(int[] nums) {

        dps(nums,0,nums.length-1);

        return;
    }

    public void dps(int[] nums,int left,int right) {
        if (right<=left)
            return;

        int mid = left + ((right - left) >> 1);

        dps(nums,left,mid);
        dps(nums,mid+1,right);

        twoArraySort(nums,left,right);
        return;
    }


    // 两个有序数组排序
    public void twoArraySort(int[] nums, int left, int right) {
        int mid = left + ((right - left) >> 1);
        int leftIndex = left;
        int rightIndex = mid + 1;

        int[] cache = new int[right - left + 1];
        int cacheIndex = 0;

        while (rightIndex <= right && leftIndex <= mid) {

            if (nums[leftIndex] > nums[rightIndex] && rightIndex <= right) {
                cache[cacheIndex] = nums[rightIndex];
                cacheIndex++;
                rightIndex++;
            } else if (nums[leftIndex] <= nums[rightIndex] && leftIndex <= mid) {
                cache[cacheIndex] = nums[leftIndex];
                cacheIndex++;
                leftIndex++;
            }
        }
        if (rightIndex > right && leftIndex <= mid) {
            for (int i = leftIndex; i <= mid; i++) {
                cache[cacheIndex++] = nums[i];
            }
        } else if (leftIndex > mid && rightIndex <= right) {
            for (int i = rightIndex; i <= right; i++) {
                cache[cacheIndex++] = nums[i];
            }
        }

        System.arraycopy(cache, 0, nums, left, cache.length );

    }


}
