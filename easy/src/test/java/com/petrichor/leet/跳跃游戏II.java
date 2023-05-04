package com.petrichor.leet;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 16:45 2023/5/4
 */
public class 跳跃游戏II {

    @Test
    public void main(){
        int nums[] = {10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(jump(nums));
    }

    public int jump(int[] nums) {
        if (nums.length==1)
            return 0;
        int left = 0;
        int right = 0;
        int res = 1;
        while (nums[left] + left < nums.length-1) {
            int start = right;
            right = nums[left] + left;
            int maxIndex = left + 1;
            for (int i = start + 1; i <= right; i++) {
                maxIndex = nums[i]+i-start >= nums[maxIndex]+maxIndex-start ? i : maxIndex;
            }
            res++;
            if (left == maxIndex){
                return -1;
            }
            left = maxIndex;
        }
        return res;
    }

}
