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
        int[] nums = { 0 ,1 , 2 , 4, 5, 6, };
//        int[] nums = {1, 0};
        int target = 1;
        System.out.println(search(nums, target));
    }

    public int search(int[] nums, int target) {

        /**
         * 找出有序
         */
        int length = nums.length;
        if (length == 0)
            return -1;
        if (length == 1)
            return target == nums[0] ? 0 : -1;

        int l = 0;
        int r = length - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (target == nums[mid])
                return mid;

            if (nums[l] <= nums[mid]) {  //判断左节点和中间节点是否在同个连续区间
                if (target >= nums[l] && target < nums[mid]) {  //目标是否在连续区间内
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {        //反之右节点和中间节点在同个连续区间
                if (target > nums[mid] && target <= nums[r]) {  //目标是否在连续区间内
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }


}

