package com.petrichor.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jh
 * @Description
 * @Date created in 10:05 2023/2/28
 */

/*
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 * 通过次数488,675提交次数632,516
 */

public class 组合 {

    @Test
    public void main() {
        int n = 2;
        int k = 1;
        List<List<Integer>> combine = combine(n, k);
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

    /*   5   3                   1                       2          3
     *                     2      3      4            3      4       4
     *                   3   4   4   5   5         4    5    5       5
     *
     * */

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        dps(res, n-k+1, k, 0, null);

        return res;
    }

    public void dps(List<List<Integer>> res, int n, int k, int root, ArrayList<Integer> last) {
        if (k==0){
            return;
        }
        for (int i = root + 1; i <= n; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(i);
            if (last != null)
                integers.addAll(last);
            if (k == 1) {
                res.add(integers);
            }
            dps(res, n+1, k - 1, i, integers);
        }
    }


}
