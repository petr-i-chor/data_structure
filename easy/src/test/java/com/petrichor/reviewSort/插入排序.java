package com.petrichor.reviewSort;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 11:18 2023/3/17
 */
public class 插入排序 {

    @Test
    public void main(){
        int [] nums = {13,2,32,5,7,3,71,8,2,12,421,43,1};
        insertionSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"\t");
        }
    }

    public void insertionSort(int [] nums){

        for (int i = 1; i < nums.length; i++) {

            for (int j = i; j >0 ; j--) {
                if (nums[j]<nums[j-1]){
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1]=tmp;
                }
            }
        }

        return;
    }

}
