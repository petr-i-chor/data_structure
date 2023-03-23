package com.petrichor.reviewSort;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 14:01 2023/3/23
 */
public class 希尔排序 {

    @Test
    public void main() {
        int[] nums = {13, 2, 32, 5, 7, 3, 71, 8, 12, 1, 421, 43, 1};
        shellSort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + "\t");
//        }
    }

    public void shellSort(int[] nums) {

        dps(nums, nums.length >> 1);
        return;
    }


    public void dps(int[] nums, int interval) {
        System.out.println("-----------");
        for (int i = 0; i < interval; i++) {

            for (int j = i; j < nums.length ; j+=interval) {
                if (j+interval>=nums.length)
                    continue;
                if (nums[j] > nums[j + interval]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + interval];
                    nums[j + interval] = tmp;
                }
            }
            for (int a = 0; a < nums.length; a++) {
                System.out.print(nums[a] + "\t");
            }
            System.out.println();
        }
        if (interval == 1)
            return;

        dps(nums, (interval+1)>>1);
    }

}
