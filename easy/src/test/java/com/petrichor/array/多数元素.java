package com.petrichor.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author jh
 * @Description
 * @Date created in 16:40 2023/2/24
 */

/*
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */

public class 多数元素 {

    @Test
    public void main(){
        int[] nums = {8,8,7,7,7};
        System.out.println(majorityElement2(nums));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //摩尔投票法  //最多的那个数大于所有的其他数相加，所以最多的数肯定是笑到最后的
    public int majorityElement2(int[] nums) {
        int res = nums[0];
        int counter = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==res){
                counter++;
            }else {
                if (counter==0){
                    res = nums[i];
                    counter ++;
                }
                counter--;
            }
        }

        return res;
    }
}
