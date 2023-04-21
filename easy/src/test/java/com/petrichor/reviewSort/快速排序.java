package com.petrichor.reviewSort;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 11:53 2023/3/17
 */
public class 快速排序 {
    @Test
    public void main() {
        int[] nums = {13, 2, 32, 5, 7, 3, 71, 8, 12, 1, 421, 43, 1};
        quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }

    public void quickSort(int[] nums) {

        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int nums[], int left, int right) {
        if (left >= right)
            return;
        int l = left;
        int r = right;
        int pivot = nums[l];    //pivot取出来,数组空一个位置，用来作为缓存，排序后再填充pivot
        while (l < r) {
            if (l < r && nums[r] > pivot) {
                r--;
            }
            nums[l] = nums[r]; // 指针第一次所指位置在pivot，pivot已经取出来，可以覆盖      指针第2-n次所指位置是覆盖操作后的原元素
            if (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
            //替换的两种情况
            //1.r--,直到r = l, l指针所指位置为可覆盖位置
            //2.l++,直到r = l, r指针所指位置为可覆盖位置
            //又因为l = r;所以nums[l]=nums[r] =pivot
        }
        nums[r] = pivot;

        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }


    //    65 32 4
    void dps(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = nums[start];
        int left = start + 1;
        int right = end;
        while (left < right) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] > pivot && left < right) {
                right--;
            }

            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }

        }

        if (nums[left] > pivot) {
            left -= 1;
        }
        int tmp = nums[start];
        nums[start] = nums[left];
        nums[left] = tmp;


        dps(nums, start, left - 1);
        dps(nums, left + 1, end);
    }
}
