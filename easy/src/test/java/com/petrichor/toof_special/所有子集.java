package com.petrichor.toof_special;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 079. 所有子集
 * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 */
public class 所有子集 {

    @Test
    public void main(){
        int [] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> integers : subsets) {
            for (Integer integer : integers) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> empty = new ArrayList<>();
        res.add(empty);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = res.get(j);
                LinkedList<Integer> item = new LinkedList<>(list);
                item.add(num);
                res.add(item);
            }
        }

        return res;
    }
}
