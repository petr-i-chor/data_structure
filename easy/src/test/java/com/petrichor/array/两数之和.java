package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 17:59 2023/1/29
 */

import org.junit.Test;

import java.util.HashSet;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 */
public class 两数之和 {

    @Test
    public void main() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum2(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "\t");
        }
    }

    public int[] twoSum(int[] nums, int target) {

        int left = -1, right = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    left = i;
                    right = j;
                    break;
                }
            }
        }

        return new int[]{left, right};
    }

    public int[] twoSum2(int[] nums, int target) {

        HashSet<Integer> set = new HashSet<>();
        int left = -1,right = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)){
                right = i;
                left = 0;
                while (nums[left] != (target-num)){
                    left++;
                }
                break;
            }else {
                set.add(target-num);
            }

        }

        return new int[]{left,right};
    }

}
