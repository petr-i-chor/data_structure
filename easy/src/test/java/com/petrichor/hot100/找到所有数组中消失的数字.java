package com.petrichor.hot100;

import org.junit.Test;

import java.util.*;

/**
 * @Author jh
 * @Description
 * @Date created in 17:21 2023/4/11
 */
public class 找到所有数组中消失的数字 {

    @Test
    public void main(){
        int nums []={4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i))
                list.add(i);
        }
        return list;
    }


}
