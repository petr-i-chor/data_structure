package com.petrichor.test;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 11:34 2022/1/13
 */
public class 合并两个有序数组 {

    /**
     * @author: jh
     * @description:给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * <p>
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * <p>
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     * 示例 2：
     * <p>
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     * 解释：需要合并 [1] 和 [] 。
     * 合并结果是 [1] 。
     * 示例 3：
     * <p>
     * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
     * 输出：[1]
     * 解释：需要合并的数组是 [] 和 [1] 。
     * 合并结果是 [1] 。
     * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
     * @params:
     * @return:
     */


    @Test
    public void main() {
        int[] nums1 = {0}, nums2 = {1};
        int m = 0, n = 1;
        merge(nums1, m, nums2, n);
        for (int i : nums1
        ) {
            System.out.println(i);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
        } else if (n == 0) {

        } else {

            int n1 = m+n-1; //nums2[] 右指针 定位要填充的位置
            int n2 = n - 1; //nums2[] 右指针 定位要排序的元素位置
            int n3 = m - 1;     //nums2[] 左指针 定位要排序的元素位置
            while (true) {
                if (n1 < 0 || n2 < 0 || n3 < 0)
                    break;
                if (nums2[n2] >= nums1[n3]) {
                   nums1[n1--] = nums2[n2--];
                   continue;
                } else {
                    /**
                     * nums1 和 nums2 判断
                     * ① nums1 大于 nums2 nums1 填充 n1, n1 n3移动 进行递归
                     * ② nums1 小于 nums2 nums2 填充 n1 （递归出口） n2 移动
                     *
                     */
                    int n1n3[] = swag(nums1, n1, nums2, n2,n3);
                    n1 = n1n3[0];
                    n3 = n1n3[1];
                    //n3小于0说明nums2表的数据全右指针右边的数，直接填充剩下的位置
                    if (n3 < 0){
                        for (int i = 0; i < n1; i++) {
                            nums1[i] = nums2[i];
                        }
                    }
                    n1--;n2--;
                }
            }
        }
    }

    //n1 nums1[]右指针位置 n2 nums2[]指针位置
    private int[] swag(int[] nums1, int n1, int[] nums2, int n2,int n3) {
        if (n3 < 0 || nums1[n3] < nums2[n2] ) {
            nums1[n1] = nums2[n2];
            return  new int[]{n1,n3};
        }
        nums1[n1] = nums1[n3];
        nums1[n3] = 0;
        return swag(nums1, n1 - 1, nums2, n2, n3-1);
    }
}
