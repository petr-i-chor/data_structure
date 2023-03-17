package com.petrichor.reviewSort;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 11:32 2023/3/17
 */
public class 选择排序 {

    @Test
    public void main(){
        int [] nums = {13,2,32,5,7,3,71,8,2,12,421,43,1};
        selectionSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"\t");
        }
    }

    public void selectionSort(int [] nums){

        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]<nums[min]){
                    min = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }



        return;
    }

}
