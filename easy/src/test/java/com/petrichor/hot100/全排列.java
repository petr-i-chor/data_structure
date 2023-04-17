package com.petrichor.hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author jh
 * @Description
 * @Date created in 20:27 2023/4/17
 */
public class 全排列 {

    @Test
    public void main(){
        int nums [] = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println();
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> head = new ArrayList<>();
        head.add(nums[0]);
        res.add(head);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int size = res.size();
            for (int i1 = 0; i1 < size; i1++) {
                List<Integer> list = res.get(0);
                for (int j = 0; j <= i; j++) {
                    List<Integer> item = new LinkedList<>(list);
                    item.add(j, num);
                    res.add(item);
                }
                res.remove(list);
            }
        }
        return res;
    }
}
