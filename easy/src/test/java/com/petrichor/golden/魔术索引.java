package com.petrichor.golden;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 11:56 2023/4/27
 */
public class 魔术索引 {

    @Test
    public void main() {
        int nums[] = {1, 3,4 ,4,5,6,7,8};
        System.out.println(findMagicIndex(nums));
    }


    public int findMagicIndex(int[] nums) {
        int l = 0;

        while (l < nums.length) {
            if (nums[l] == l) {
                return l;
            } else {
                l = Math.max(nums[l],l+1);
            }
        }
        return -1;
    }
}
