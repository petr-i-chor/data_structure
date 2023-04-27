package com.petrichor.golden;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 16:32 2023/4/27
 */
public class 连续数列 {

    @Test
    public void main(){
       int nums [] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]>0) {
                nums[i] += nums[i - 1];
            }
            max= Math.max(nums[i],max);
        }

        return max;
    }
}
