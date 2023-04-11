package com.petrichor.hot100;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 16:53 2023/4/11
 */
public class 移动零 {

    @Test
    public void main() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(nums);
    }

    public void moveZeroes(int[] nums) {
        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                offset++;
            else {
                if (offset > 0) {
                    int tmp = nums[i];
                    nums[i - offset] = tmp;
                    nums[i] = 0;
                }
            }
        }
    }
}
