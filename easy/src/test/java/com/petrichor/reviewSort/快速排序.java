package com.petrichor.reviewSort;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 11:53 2023/3/17
 */
public class 快速排序 {
    @Test
    public void main() {
        int[] nums = {13, 2, 32, 5, 7, 3, 71, 8, 12,1, 421, 43, 1};
        quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }

    public void quickSort(int[] nums) {

        dps(nums, 0, nums.length - 1);
        return;
    }

    //    65 32 4
    void dps(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = nums[start];
        int left = start + 1;
        int right = end;
        while (left < right) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] > pivot && left < right) {
                right--;
            }

            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }

        }

        if (nums[left] > pivot) {
            left -= 1;
        }
        int tmp = nums[start];
        nums[start] = nums[left];
        nums[left] = tmp;


        dps(nums, start, left - 1);
        dps(nums, left + 1, end);


    }
}
