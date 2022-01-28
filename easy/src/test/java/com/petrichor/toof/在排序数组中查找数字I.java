package com.petrichor.toof;

import org.junit.Test;

import java.lang.annotation.Target;

/**
 * @Author jh
 * @Description
 * @Date created in 10:07 2022/1/28
 */
public class 在排序数组中查找数字I {

    /**
     * @author: jh
     * @description:统计一个数字在排序数组中出现的次数。  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -109 <= target <= 109
     * @params:
     * @return:
     */


    @Test
    public void main() {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int res = search2(arr, 11);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == target) count++;
        return count;
    }

    public int search2(int[] nums, int target) {
        return partition(nums, target, 0, nums.length - 1);
    }

    public int partition(int[] nums, int target, int l, int r) {
        if (l>r) return 0;
        int mid = ((r - l) >> 1) + l;
        if (nums[mid] > target)
            return partition(nums, target, l, mid - 1);
        else if (nums[mid] < target)
            return partition(nums, target, mid + 1, r);
        else {
            int count = 1;
            int lp = mid - 1;
            int rp = mid + 1;
            while (lp >= 0 && nums[lp--] == nums[mid]) count++;
            while (rp < nums.length && nums[rp++] == nums[mid]) count++;
            return count;
        }
    }

}
