package com.petrichor.inew;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class subsets {

    @Test
    public void main() {
        int[] nums = {1, 2, 3};
        subsets(nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            res.add(list);
            dps(nums, i,res,nums.length,list);
        }
        res.add(new ArrayList<>());
        return res;
    }
    public void dps(int[] nums, int index, List<List<Integer>>res, int n, ArrayList<Integer> list) {

        for (int i = index + 1; i < nums.length; i++) {
            ArrayList<Integer> list1 = new ArrayList<>(list);
            list1.add(nums[i]);
            if (list1.size() <= n) {
                res.add(list1);
                dps(nums, i, res, n, list1);
            }
        }
    }
}
