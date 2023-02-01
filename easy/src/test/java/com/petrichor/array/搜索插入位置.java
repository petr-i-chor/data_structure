package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 15:24 2023/1/31
 */

import org.junit.Test;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 */
public class 搜索插入位置 {

    @Test
    public void main() {
        int nums[] = {1, 3, 5, 7};
        int target = 6;
        System.out.println(searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    //1,2,5    3      1,2,5,6 3
    public int binarySearch(int[] nums, int target, int start, int end) {

        if (start == end && nums[start] != target) {
            if (nums[start] > target)
                return start;
            else
                return start + 1;
        }
        if (start > end && nums[start] != target) {
            return start;
        }
        int mid = start + (end - start >> 1);
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, end);
        } else {
            return binarySearch(nums, target, start, mid - 1);
        }
    }

}
