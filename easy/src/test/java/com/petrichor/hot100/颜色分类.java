package com.petrichor.hot100;

import org.junit.Test;

public class 颜色分类 {

    @Test
    public void main(){
        int [] nums = {2,0,1};
        sortColors(nums);
        System.out.println();
    }
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int cur = 0;
        while (left<right&&cur<=right){
            if (nums[cur]==0){
                int tmp = nums[left];
                nums[left] = nums[cur];
                nums[cur] = tmp;
                cur++;
                left++;
            }else if (nums[cur]==2){
                int tmp = nums[right];
                nums[right] = nums[cur];
                nums[cur] = tmp;
                right--;
            }else {
                cur++;
            }
        }
    }

}
