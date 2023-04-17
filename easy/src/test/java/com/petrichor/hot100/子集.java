package com.petrichor.hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jh
 * @Description
 * @Date created in 19:50 2023/4/17
 */
public class 子集 {
    @Test
    public void main(){
        int [] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println();
    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(list);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> integers = res.get(j);
                List<Integer> item = new ArrayList<>(integers);
                item.add(num);
                res.add(item);
            }
        }
        return res;
    }
}
