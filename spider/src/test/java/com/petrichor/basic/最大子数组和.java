package com.petrichor.basic;

/**
 * @Author jh
 * @Description
 * @Date created in 9:23 2023/2/16
 */

import org.junit.Test;

/*
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */

public class 最大子数组和 {

    @Test
    public void main() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(nums));
    }

    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int cur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (cur < 0) {
                cur = nums[i];
            } else {
                cur += nums[i];
            }
            max = Math.max(cur, max);
        }

        return max;
    }

    //动态规划
    public int maxSubArray2(int[] nums) {

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < 0) {
                max = Math.max(nums[i], max);
            } else {
                nums[i] += nums[i - 1];
                max = Math.max(nums[i], max);
            }
        }

        return max;
    }

}
