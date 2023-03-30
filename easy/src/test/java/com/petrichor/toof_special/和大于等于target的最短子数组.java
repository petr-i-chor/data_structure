package com.petrichor.toof_special;


import org.junit.Test;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class 和大于等于target的最短子数组 {

    @Test
    public void main() {
//        int[] nums = {2, 3, 1, 2, 4, 3};
        int[] nums = {2};
        System.out.println(minSubArrayLen2(8, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=target){
                return 1;
            }

            int acc = nums[i];
            int cur = i;
            while (acc < target && cur < nums.length - 1) {
                acc += nums[++cur];
            }
            if (acc >= target) {
                min = Math.min(min, cur - i + 1);
            }

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int min = Integer.MAX_VALUE;

        if (nums[0] > target)
            return 1;
        if (nums.length==1)
            return nums[0]>target?1:0;

        int left = 0;
        int right = 1;
        int acc = nums[left] + nums[right];

        while (right < nums.length) {
            if (min==1)
                return min;
            if (acc >= target) {
                min = Math.min(min, right - left + 1);
                acc -= nums[left++];
            } else {
                if (right + 1 >= nums.length)
                    break;
                acc += nums[++right];
            }

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }


}
