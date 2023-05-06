package com.petrichor.leet;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 15:25 2023/5/6
 */
public class 寻找数组的中心下标 {

    @Test
    public void main(){
        int nums [] = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int i = 1; i < nums.length; i++) {
            total+=nums[i];
        }
        if (total==0){
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == total - nums[i]){
                return i;
            }else {
                total -= nums[i];
                nums[i] += nums[i - 1];
            }
        }
        return -1;
    }
}
