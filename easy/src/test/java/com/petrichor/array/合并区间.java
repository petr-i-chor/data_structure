package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 9:38 2023/1/29
 */

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class 合并区间 {

    @Test
    public void main() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{2, 4}, {0, 1}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(merge[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> collect = Arrays.stream(intervals).sorted(Comparator.comparingInt(value -> value[0])).collect(Collectors.toList());
        ArrayList<int[]> res = new ArrayList<>();
        res.add(collect.get(0));
        for (int i = 1; i < collect.size(); i++) {
            /**
             * 三种情况
             * 1 包含
             * 2 交集
             * 3 没有关系
             */
            int[] left = res.get(res.size()-1);
            int[] right = collect.get(i);
            if (left[0] == right[0]){
                //包含
                res.remove(res.size()-1);
                res.add(left[1]>right[1]?left:right);
            }else {
                if (left[1] >= right[0]){
                    if (left[1] >= right[1]){
                        //包含
                        res.remove(res.size()-1);
                        res.add(left[0]<right[0]?left:right);
                    }else {
                        //交集
                        res.remove(res.size()-1);
                        int[] ints = {left[0], right[1]};
                        res.add(ints);
                    }
                }else {
                    res.add(right);
                }

            }

        }

        return res.toArray(new int[0][]);
    }





}
