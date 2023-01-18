package com.petrichor.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @Author jh
 * @Description
 * @Date created in 13:47 2023/1/16
 */
public class 寻找两个正序数组的中位数 {

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * <p>
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     * <p>
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     */

    @Test
    public void main() {
//        int[] nums1 = new int[]{1, 3};
//        int[] nums2 = new int[]{2, 4};
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2,3};
        System.out.println(findMedianSortedArrays2(nums1, nums2));

    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 奇数，中间那位
         * 偶数，中间两位的和
         */
        int totalLen = nums1.length + nums2.length;
        int[] total = new int[totalLen];
        int nums1Index = 0;
        int nums2Index = 0;

        for (int i = 0; i < totalLen; i++) {
            if (nums1Index < nums1.length && nums2Index < nums2.length && nums1[nums1Index] <= nums2[nums2Index]) {
                total[i] = nums1[nums1Index];
                nums1Index++;
            } else if (nums1Index < nums1.length && nums2Index < nums2.length && nums1[nums1Index] > nums2[nums2Index]) {
                total[i] = nums2[nums2Index];
                nums2Index++;
            } else {
                if (nums1Index == nums1.length) {
                    for (; nums2Index < nums2.length; nums2Index++) {
                        total[i] = nums2[nums2Index];
                        i++;
                    }
                    break;
                } else {
                    for (; nums1Index < nums1.length; nums1Index++) {
                        total[i] = nums1[nums1Index];
                        i++;
                    }
                    break;
                }
            }
        }

        System.out.println();
        return totalLen % 2 == 0 ? (total[totalLen / 2] + (float) total[totalLen / 2 - 1]) / 2 : total[totalLen / 2];
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        /**
         * 奇数，中间那位
         * 偶数，中间两位的和
         * 避免产生新数组
         */
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int totalLen = nums1Len + nums2Len;
        int num1Index = 0;
        int num2Index = 0;
        if (totalLen % 2 == 1) {
            //奇数，找中间位置的数字
            int mid = (totalLen) / 2;

            while (num1Index < nums1Len && num2Index < nums2Len) {
                if (nums1[num1Index] <= nums2[num2Index]) {
                    if (num1Index + num2Index == mid) {
                        return nums1[num1Index];
                    }
                    num1Index++;
                } else {
                    if (num1Index + num2Index == mid) {
                        return nums2[num2Index];
                    }
                    num2Index++;
                }
            }
            if (num1Index != nums1Len && num2Index == nums2Len){
                return nums1[mid-nums2Len];
            }
            if (num2Index != nums2Len && num1Index == nums1Len){
                return nums2[mid-nums1Len];
            }
        }else {
            //偶数数，找中间位置的数字以及前一位
            int mid2 = (totalLen) / 2;
            int mid1 = mid2-1;

            int midNum1 = -1;
            int midNum2 = -1;

            while (num1Index < nums1Len && num2Index < nums2Len) {
                if (nums1[num1Index] <= nums2[num2Index]) {
                    if (num1Index + num2Index == mid1) {
                        midNum1 =  nums1[num1Index];
                    }
                    if (num1Index + num2Index == mid2) {
                        midNum2 =  nums1[num1Index];
                        return (midNum1+(float)midNum2)/2;
                    }
                    num1Index++;
                } else {
                    if (num1Index + num2Index == mid1) {
                        midNum1 = nums2[num2Index];
                    }
                    if (num1Index + num2Index == mid2) {
                        midNum2 = nums2[num2Index];
                        return (midNum1+(float)midNum2)/2;
                    }
                    num2Index++;
                }
            }
            //  1234 5678  0123 456789
            if (num1Index != nums1Len && num2Index == nums2Len && midNum1 == -1){
                midNum1 = nums1[mid1-nums2Len];
            }
            if (num2Index != nums2Len && num1Index == nums1Len && midNum1 == -1){
                midNum1 = nums2[mid1-nums1Len];
            }
            if (num1Index != nums1Len && num2Index == nums2Len && midNum1 != -1){
                midNum2 = nums1[mid2-nums2Len];
            }
            if (num2Index != nums2Len && num1Index == nums1Len && midNum1 != -1){
                midNum2 = nums2[mid2-nums1Len];
            }

            return (midNum1+(float)midNum2)/2;

        }
        return 0;
    }

}
