package com.petrichor.test;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author jh
 * @Description
 * @Date created in 10:35 2022/1/13
 */
public class 两数之和 {

    /**
     *
     * @author: jh
     * @description:
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     * @params:
     * @return:
     *
     */


    @Test
    public void main() {
        int[] ints = {1,1,1,1,1,4,1,1,1,1,1,7,1,1,1,1,1};
        int target = 11;
        int[] sum = twoSum2(ints, target);
        System.out.println(sum[0]+","+sum[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        /**
         * 先判断存不存在
         * 不存在加入差数
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.put(nums[i],i);
            if (value==null){
                map.remove(nums[i]);
                map.put(target-nums[i],i);
                continue;
            }
            return new int[]{value,i};
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        /**
         * 先判断存不存在
         * 不存在加入差数
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(target-nums[i],i);
                continue;
            }
            return new int[]{map.get(nums[i]),i};
        }
        return null;
    }
}
