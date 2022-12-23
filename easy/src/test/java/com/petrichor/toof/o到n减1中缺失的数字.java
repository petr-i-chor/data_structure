package com.petrichor.toof;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 11:10 2022/1/28
 */
public class o到n减1中缺失的数字 {

    /**
     * @author: jh
     * @description:一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [0,1,3]
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [0,1,2,3,4,5,6,7,9]
     * 输出: 8
     * @params:
     * @return:
     */


    @Test
    public void main() {
        System.out.println(missingNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    public int missingNumber(int[] nums) {

        return partition(nums, 0, nums.length - 1);
    }

    public int partition(int[] nums, int l, int r) {
        int mid = ((r - l) >> 1) + l;
        if (nums[mid] > mid) {
            if (mid == l)
                return nums[l];
            if (nums[mid - 1] == mid - 1)
                return mid;
            else
                return partition(nums, l, mid - 1);
        } else {
            if (mid == r)
                return nums[r];
            if (nums[mid + 1] > mid + 1)
                return mid + 1;
            else
                return partition(nums, mid + 1, r);
        }
    }

}
