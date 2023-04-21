package com.petrichor.hot100;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 15:35 2023/4/21
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    @Test
    public void main() {
        int[] nums = {1};
        int[] ints = searchRange(nums, 1);
        System.out.println(ints[0] + " " + ints[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = {-1, -1};
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                int m = mid;
                while (mid >= 0 && nums[mid] == target) {
                    if (mid == 0) {
                        res[0] = mid;
                    } else if (nums[mid - 1] != target) {
                        res[0] = mid;
                    }
                    mid--;
                }
                mid = m;
                while (mid <= nums.length - 1 && nums[mid] == target) {
                    if (mid == nums.length - 1) {
                        res[1] = mid;
                    } else if ((nums[mid + 1] != target)) {
                        res[1] = mid;
                    }
                    mid++;
                }
                break;
            }
        }
        return res;
    }


}
