package com.petrichor.toof;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 14:37 2022/9/16
 */
public class 连续子数组的最大和 {

    /**
     * 剑指 Offer 42. 连续子数组的最大和
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * <p>
     * 要求时间复杂度为O(n)。
     * <p>
     * <p>
     * <p>
     * 示例1:
     * <p>
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length <= 10^5
     * -100 <= arr[i] <= 100
     */
    @Test
    public void test() {
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4,7};
//        int[] ints = {-2, 3, 1, 3};
        System.out.println(maxSubArray3(ints));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cumulative_num = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= 0)
                max = max > nums[i] ? max : nums[i];
            else if (nums[i] >= 0 && nums[i] != -1) {
                cumulative_num = nums[i];
            }

            cumulative_num = cumulative_num + nums[i];
            if (cumulative_num > 0) {
                if (nums[i] >= 0) {
                    max = max > cumulative_num ? max : cumulative_num;
                }
            } else {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > 0) {
                        cumulative_num = nums[j];
                        max = max > cumulative_num ? max : cumulative_num;
                        i = j;
                        break;
                    }
                }
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int cumulative_num = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] <= 0)
                max = max > nums[i] ? max : nums[i];
            else if (nums[i] > 0) {
                cumulative_num = nums[i];
                max = cumulative_num;
                break;
            }
        }
        for (i = i + 1; i < nums.length; i++) {
            cumulative_num = cumulative_num + nums[i];
            if (cumulative_num > 0) {
                if (nums[i] >= 0) {
                    max = max > cumulative_num ? max : cumulative_num;
                }
            } else {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > 0) {
                        cumulative_num = nums[j];
                        max = max > cumulative_num ? max : cumulative_num;
                        i = j;
                        break;
                    }
                }
            }
        }

        return max;
    }

    public int maxSubArray3(int[] nums) {
        int max =nums[0];
        int pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre +nums[i],nums[i]);
            max = Math.max(max,pre);
        }

        return max;
    }
}
