package com.petrichor.hot100;

import org.junit.Test;

import java.util.Random;

/**
 * @Author jh
 * @Description
 * @Date created in 10:53 2023/4/21
 */
public class 数组中的第K个最大元素 {
    private Random random = new Random();

    @Test
    public void main() {
        int num[] = {3, 2, 4, 5, 5, 6, 2, 3, 1};
        int kthLargest = findKthLargest(num, 3);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, k, 0, nums.length - 1);
    }

    private int quickSort(int nums[], int k, int left, int right) {
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

        if (r==nums.length-k){
            return nums[r];
        }else if (r>nums.length-k){
            return  quickSort(nums, k, left, l-1);
        }else {
            return  quickSort(nums, k, l+1, right);
        }
    }

}
