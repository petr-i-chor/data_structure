package com.petrichor.array;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 9:23 2022/9/28
 */
public class 搜索旋转排序数组 {

    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * <p>
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * <p>
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：nums = [1], target = 0
     * 输出：-1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * nums 中的每个值都 独一无二
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -104 <= target <= 104
     */
    @Test
    public void test() {
//        int[] nums = { 0 ,1 , 2 , 4,5, 6, };
        int[] nums = {1, 0};
        int target = 1;
        System.out.println(search(nums, target));
    }

    public int search(int[] nums, int target) {

        //直接二分查找

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                index = nums.length >> 1;
                break;
            }
            if (nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }

        //二分查找
        if (nums[index] == target)
            return index;
        else if (nums[index-1] >= target && nums[0] <= target) {
            return binarySearch(0, index-1, nums, target);
        } else if (nums[index] <= target && nums[nums.length - 1] >= target) {
            return binarySearch(index, nums.length - 1, nums, target);
        } else {
            return -1;
        }
    }

    public int binarySearch(int begin, int end, int[] nums, int target) {
        if (nums[begin] == target)
            return begin;
        if (nums[end] == target)
            return end;

        if (end < begin)
            return -1;

        int pivot = begin + ((end - begin) >> 1);
        if (nums[pivot] == target)
            return pivot;
        else if (nums[pivot] > target) {
            return binarySearch(begin, pivot - 1, nums, target);
        } else {
            return binarySearch(pivot + 1, end, nums, target);
        }
    }

      /*      int[] copy = new int[nums.length];
        int cur = index;
        for (int i = 0; i < nums.length; i++) {
            if (cur == nums.length)
                cur = 0;
            if (cur < nums.length)
                copy[i] = nums[cur++];
        }*/
}

