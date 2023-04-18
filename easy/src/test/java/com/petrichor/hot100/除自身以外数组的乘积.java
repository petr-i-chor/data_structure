package com.petrichor.hot100;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 10:23 2023/4/18
 */
public class 除自身以外数组的乘积 {

    @Test
    public void main(){
        int [] nums = {1,2,3};
        int[] res = productExceptSelf(nums);
        System.out.println();
    }

    public int[] productExceptSelf(int[] nums) {
        int [] res = new int[nums.length];
        int leftProduct = 1;
        for (int i = 0; i < nums.length ; i++) {
            res[i] = leftProduct;
            leftProduct*=nums[i];
        }

        int rightProduct = 1;
        for (int i = nums.length-1; i >=0 ; i--) {
            res[i] *=rightProduct;
            rightProduct*=nums[i];
        }
        return res;
    }

}
