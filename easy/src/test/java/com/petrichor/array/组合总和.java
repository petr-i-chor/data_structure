package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 16:59 2023/2/24
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 */


public class 组合总和 {

    @Test
    public void main() {
        int[] candidates = {2};
        List<List<Integer>> lists = combinationSum(candidates, 1);
        System.out.println();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];
            for (int j = 0; j < target / candidate; j++) {
                List<Integer> item = new ArrayList<>();
                for (int k = 0; k <= j; k++) {
                    item.add(candidate);
                }
                if (target == (j + 1) * candidate)
                    res.add(item);
                else
                    backtrack(res, item, target - (j + 1) * candidate, candidates, i + 1);
            }
        }
        return res;
    }

    public boolean backtrack(List<List<Integer>> res, List<Integer> patent, int target, int[] candidates, int index) {
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (candidate > target)
                return false;
            for (int j = 0; j < target / candidate; j++) {
                List<Integer> item = new ArrayList<>();
                item.addAll(patent);
                for (int k = 0; k <= j; k++) {
                    item.add(candidate);
                }
                if (target - (j + 1) * candidate == 0)
                    res.add(item);
                else
                    backtrack(res, item, target - (j + 1) * candidate, candidates, i + 1);
            }
        }
        return false;
    }
}
