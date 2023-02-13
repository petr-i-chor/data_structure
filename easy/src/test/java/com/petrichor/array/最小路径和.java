package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 9:25 2023/2/8
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 */
public class 最小路径和 {

    @Test
    public void main() {
//        [[-1],[2,3],[1,-1,-3]]
        int[][] arr = {{-1}};
//        int[][] arr = {{-1}, {2, 3}, {1, -1, -3}};
//        int[][] arr = {{2}, {3, 4}, {6, 5, 7},{4,1,8,3}};
//        int[][] arr = {{-10},{-11,-11},{-12,-13,-14}};
        ArrayList<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                list.add(arr[i][j]);
            }
            triangle.add(list);
        }
        System.out.println(minimumTotal2(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int[] res = {Integer.MAX_VALUE};
        dfs(triangle, 1, 0, triangle.get(0).get(0), res);
        return res[0];
    }

    //超时啦
    public void dfs(List<List<Integer>> triangle, int layer, int index, int res, int[] min) {

        Integer left = triangle.get(layer).get(index);
        Integer right = triangle.get(layer).get(index + 1);

        if (layer == triangle.size() - 1) {
            min[0] = Math.min(min[0], Math.min(res + left, res + right));
            return;
        }

        dfs(triangle, layer + 1, index, res + left, min);
        dfs(triangle, layer + 1, index + 1, res + right, min);
    }

    /*
     * 2            4 1 8 3        4 1 8 3
     * 3 4            6 5 7          7 6 10
     * 6 5 7            3 4            9 10
     * 4 1 8 3            2               2
     * */

    public int minimumTotal2(List<List<Integer>> triangle) {

        for (int i = triangle.size()-1; i >0; i--) {
            List<Integer> list = triangle.get(i);
            List<Integer> second = triangle.get(i - 1);
            for (int i1 = 0; i1 < list.size()-1; i1++) {
                second.set(i1,second.get(i1)+Math.min(list.get(i1),list.get(i1+1)));
            }
        }

        return triangle.get(0).get(0);
    }
}
