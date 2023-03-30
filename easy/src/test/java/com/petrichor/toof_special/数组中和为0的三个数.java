package com.petrichor.toof_special;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class 数组中和为0的三个数 {

    @Test
    public void main(){
        int nums [] = {0,0,0};
        for (List<Integer> integers : threeSum(nums)) {
            for (Integer integer : integers) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; ) {
            //大于0直接放回，三数之和不可能=0了！！！
            if (nums[i] > 0) {
                return res;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                if (nums[left]+nums[right]+nums[i]==0){
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(list);
                    left++;
                    right--;
                    while (nums[left]==nums[left-1]&&left<right){   //去重
                        left++;
                    }
                    while (nums[right]==nums[right+1]&&left<right){ //去重
                        right--;
                    }
                }else if (nums[left]+nums[right]+nums[i]>0){
                    right--;
                }if (nums[left]+nums[right]+nums[i]<0){
                    left++;
                }
            }
            i++;
            while (nums[i]==nums[i-1]&&i<nums.length-2){     //去重
                i++;
            }
        }


        return res;
    }










}
