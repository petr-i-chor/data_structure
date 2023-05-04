package com.petrichor.hot100;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 17:21 2023/5/4
 */
public class 跳跃游戏 {
    @Test
    public void main() {
        int nums[] = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public boolean canJump(int[] nums) {

        if (nums.length == 1)
            return true;
        int left = 0;
        int right = 0;
        while (nums[left] + left < nums.length - 1) {
            if (nums[left]==0)
                return false;
            int start = right;
            right = nums[left] + left;
            int maxIndex = left + 1;
            for (int i = start + 1; i <= right; i++) {
                maxIndex = nums[i] + i - start >= nums[maxIndex] + maxIndex - start ? i : maxIndex;
            }
            if (left == maxIndex) {
                return false;
            }
            left = maxIndex;
        }
        return true;

    }
}
