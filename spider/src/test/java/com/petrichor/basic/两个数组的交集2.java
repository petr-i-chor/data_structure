package com.petrichor.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author jh
 * @Description
 * @Date created in 16:33 2022/1/13
 */
public class 两个数组的交集2 {
    /**
     * @author: jh
     * @description: 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
     * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 示例 2:
     * <p>
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums1.length, nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 1000
     * @params:
     * @return:
     */

    @Test
    public void main() {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersect = intersect(nums1, nums2);
        for (int i : intersect
        ) {
            System.out.println(i);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();;
        for (int i : nums1
        ) {
            if (map.containsKey(i))
                map.put(i, map.get(i).intValue() + 1);
            else
                map.put(i, 1);
        }
        for (int i : nums2) {

            if (map.containsKey(i)) {
                map.put(i, map.get(i).intValue() - 1);
                if (map.get(i) >= 0)
                    list.add(i);
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

}
