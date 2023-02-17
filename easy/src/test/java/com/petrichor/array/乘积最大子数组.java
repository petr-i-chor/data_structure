package com.petrichor.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author jh
 * @Description
 * @Date created in 10:31 2023/2/16

/*
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 */
public class 乘积最大子数组 {

    @Test
    public void main() {
        int[] nums = {-2,0,-1};
        System.out.println(maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }

        int[] copy = new int[nums.length];
        copy[0]=nums[0];

        for (int i = 1; i < nums.length; i++) {
            copy[i]=nums[i];
            if (nums[i-1]!=0) {
                copy[i] *= copy[i - 1];
            }
        }
        int max =copy[0];
        for (int i = 1; i < nums.length; i++) {
            max =Math.max(copy[i],max);
        }
        for (int i = nums.length-2; i >=0 ; i--) {
            if (nums[i+1]!=0) {
                nums[i] *= nums[i + 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            max =Math.max(nums[i],max);
        }

        return max;
    }
}
