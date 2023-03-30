package com.petrichor.toof_special;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author jh
 * @Description
 * @Date created in 19:38 2023/3/30
 */

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 */

public class 乘积小于K的子数组 {

    @Test
    public void main() {
        int nums[] = {1,2};
        System.out.println(numSubarrayProductLessThanK(nums, 1));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;

        int multi = nums[left];
        int res = multi >= k ? 0 : 1;

        for (int i = 1; i < nums.length; i++) {
            multi *= nums[i];
            if (multi < k) {
                res += i - left + 1;
            } else {
                while (left < i && multi >= k) {
                    multi = multi / nums[left];
                    left++;
                }
                if (left == i) {
                    if (multi < k) {
                        res++;
                    } else {
                        left++;
                        if (left == nums.length)
                            break;
                        multi = nums[left];
                        if (multi < k)
                            res++;
                    }
                } else {
                    res += i - left + 1;
                }

            }
        }

        return res;
    }


}
