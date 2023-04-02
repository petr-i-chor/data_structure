package com.petrichor.toof_special;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 083. 没有重复元素集合的全排列
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class 没有重复元素集合的全排列 {

    @Test
    public void main(){
        int [] nums = {1};
        for (List<Integer> integers : permute(nums)) {
            for (Integer integer : integers) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = Arrays.asList(nums[0]);
        res.add(one);

        for (int i = 1; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List list = res.get(0);
                for (int k = 0; k < i+1; k++) {
                    LinkedList<Integer> integers = new LinkedList<Integer>(list);
                    integers.add(k,nums[i]);
                    res.add(integers);
                }
                res.remove(list);
            }
        }
        return res;
    }

}
