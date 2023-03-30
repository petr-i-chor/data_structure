package com.petrichor.toof_special;

/**
 * @Author jh
 * @Description
 * @Date created in 20:38 2023/3/28
 */

import org.junit.Test;

import java.util.HashMap;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
 * <p>
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[0,2]
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 递增顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 */
public class 排序数组中两个数字之和 {

    @Test
    public void main() {
        int[] numbers = {1,2,4,6,10};
        int[] ints = twoSum2(numbers, 10);
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }
    }

    public int[] twoSum(int[] numbers, int target) {    //没注意关键字，排序

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int[] res = new int[2];
                res[0] = map.get(numbers[i]);
                res[1] = i;
                return res;
            } else {
                map.put(target - numbers[i], i);
            }

        }
        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] res = new int[2];
        while (left<right){
            if (numbers[left]+numbers[right]==target) {
                res[0]=left;
                res[1]=right;
                return res;
            }else if (numbers[left]+numbers[right]<target){
                left++;
            }else if (numbers[left]+numbers[right]>target){
                right--;
            }

        }
        return null;
    }

}
