package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 13:46 2023/1/29
 */

import org.junit.Test;

import java.util.ArrayList;

/**
 * 57. 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], left = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], left = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 * <p>
 * 输入：intervals = [], left = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 * <p>
 * 输入：intervals = [[1,5]], left = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 * <p>
 * 输入：intervals = [[1,5]], left = [2,7]
 * 输出：[[1,7]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * left.length == 2
 * 0 <= left[0] <= left[1] <= 105
 */
public class 插入区间 {

    @Test
    public void main() {
        int[][] intervals = {{2, 5}, {6, 7}, {8, 9}};
        int[] left = new int[]{0, 1};
        int[][] insert = insert(intervals, left);
        for (int i = 0; i < insert.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(insert[i][j]);
            }
            System.out.println();
        }
    }

    //    345 12
    //    345 13
    //
    //    345 67
    //    345 57
    //
    //    345 45


    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0){
            return new int[][]{newInterval};
        }
        ArrayList<int[]> res = new ArrayList<>();
        res.add(newInterval);
        for (int i = 0; i < intervals.length; i++) {
            int[] left = res.get(res.size() - 1);
            int[] right = intervals[i];
            /**
             * 包含 并集 没有关系
             */
            //没有关系
            if (left[0] > right[1]) {
                res.remove(left);
                res.add(right);
                res.add(left);
            } else if (left[1] < right[0]) {
                for (int j = i; j < intervals.length; j++) {
                    res.add(intervals[j]);
                }
                break;
            }
            //包含
            else if (left[0] <= right[0] && left[1] >= right[1]) {
                continue;
            } else if (left[0] >= right[0] && left[1] <= right[1]) {
                res.remove(left);
                res.add(right);
            }
            //并集
            else {
                if (left[0] >= right[0]) {
                    int[] ints = {right[0], left[1]};
                    res.remove(left);
                    res.add(ints);
                } else {
                    int[] ints = {left[0], right[1]};
                    res.remove(left);
                    res.add(ints);
                }

            }
        }
        return res.toArray(new int[0][]);
    }
}
