package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 14:28 2023/2/1
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class 最长连续序列 {

    @Test
    public void main() {
        int nums[] = {100, 3, 2, 1, 4};
        System.out.println(longestConsecutive2(nums));
    }

    public int longestConsecutive(int[] nums) {

        /**
         * 解法1，遍历set，遍历当前数n是否存在n+1，存在再判断n+2，，n+k，时间复杂度接近o（n2），
         *
         * 优化后
         *      ：减少当前数n重复遍历，如存在n-1则说明遍历过
         */

        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int num;
        int curCount = 1;
        int longestCount = 1;

        for (Integer integer : set) {
            num = integer;
            //很关键**, set不存在num+1，直接跳过，set存在num-1，说明num-1已经经过遍历了，不要重复遍历（如1 会遍历 1-2-3-4 ，2会遍历 2-3-4，优化后，2判断1是否存在，存在即说明2-3-4遍历过）
            if (!set.contains(num + 1) || set.contains(num - 1))
                continue;
            else {
                do {
                    curCount++;
                    num = num + 1;
                } while (set.contains(num + 1));
                longestCount = longestCount >= curCount ? longestCount : curCount;
                curCount = 1;
            }
        }
        return longestCount;
    }


    public int longestConsecutive2(int[] nums) {

        /**
         * 解法2 遍历列表 找到基于当前数的最长序列后删除元素
         */

        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int curCount = 1;
        int longestCount = 1;

        for (int num : nums) {
            int pivot = num;
            while (set.contains(++num)) {
                curCount++;
                set.remove(num);
            }
            while (set.contains(--pivot)) {
                curCount++;
                set.remove(pivot);
            }
            longestCount = Math.max(curCount, longestCount);
            curCount = 1;
        }
        return longestCount;
    }


}
