package com.petrichor.golden;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 16:27 2023/4/27
 */
public class 消失的数字 {

    @Test
    public void main() {
        int nums[] = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i <= nums.length; i++) {
            res ^= i;
        }

        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
