package com.petrichor.golden;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author jh
 * @Description
 * @Date created in 17:18 2023/4/27
 */
public class 主要元素 {

    @Test
    public void main(){
        int nums[]={1,2,3};
        System.out.println(majorityElement(nums));
    }


    public int majorityElement(int[] nums) {
        int res =1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==num){
                res++;
            }else {
                if (res==1){
                    num = nums[i];
                }else {
                    res--;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==num){
                count++;
                if (count==nums.length+1>>1)
                    return num;
            }
        }

        return -1;
    }
}
