package com.petrichor.hot100;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 16:30 2023/4/21
 */
public class 最短无序连续子数组 {

    @Test
    public void main() {
        int nums[] = {1, 3, 2, 2, 4};
        System.out.println(findUnsortedSubarray(nums));
    }
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;

        }
        while (left < nums.length - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }
        if (left >= right)
            return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        while (left > 0 && nums[left - 1] > min) {
            left--;
        }

        // 从右向左找到 right 的正确位置
        while (right < nums.length - 1 && nums[right + 1] < max) {
            right++;
        }

        // 返回最短无序连续子数组的长度
        return right - left + 1;
    }

}
