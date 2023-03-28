package com.petrichor.toof2_special;

/**
 * @Author jh
 * @Description
 * @Date created in 20:10 2023/3/28
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *  
 *
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 */
public class 只出现一次的数字 {

    @Test
    public void main(){
        int [] nums = {-2,-2,1,1,4,1,4,4,-4,-2};
        System.out.println(singleNumber2(nums));
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1)
                return entry.getKey();
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        if (nums.length==1)
            return nums[0];
        Arrays.sort(nums);
        if (nums[0]!=nums[1])
            return nums[0];
        if (nums[nums.length-1]!=nums[nums.length-2])
            return nums[nums.length-1];

        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i]!=nums[i-1]&&nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    public int singleNumber3(int[] nums) {
        return -1;
    }
}
