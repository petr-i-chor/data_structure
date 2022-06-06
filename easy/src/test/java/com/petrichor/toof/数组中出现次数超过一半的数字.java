package com.petrichor.toof;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author jh
 * @Description
 * @Date created in 17:34 2022/2/8
 */



public class 数组中出现次数超过一半的数字 {


    /**
     *
     * @author: jh
     * @description:
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *
     *
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     *
     *
     * 限制：
     *
     * 1 <= 数组长度 <= 50000
     * @params:
     * @return:
     *
     */


    @Test
    public void main(){
//        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(majorityElement(new int[]{}));
    }

    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int count ;
        int result = -1;

        for (int num:nums) {
            if (!map.containsKey(num))
                map.put(num,count = 1);
            else
                map.put(num,count = map.get(num)+1);
            if (count>max){
                max = count; result = num;
            }
//            max = count > max ? count : max;
        }
        return result;
    }

}
