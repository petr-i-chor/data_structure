package com.petrichor.dp;

/**
 * @Author jh
 * @Description
 * @Date created in 14:38 2023/2/13
 */

import org.junit.Test;

/**
 * 剑指 Offer II 088. 爬楼梯的最少成本
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 *
 * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
 *
 * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 *  示例 2：
 *
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 *
 *
 * 提示：
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
public class 爬楼梯的最少成本 {

    @Test
    public void main(){
        int [] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        /**
         * 动态规划
         * 思路：到达终点 n 总共需要花费的费用 可以看成到n-1和n-2两个中比较低的费用，以此为例，n-i可以看成 n-i-1和n-i-2中比较低的费用
         * 方法：以空间换时间，n的值等于n本身的值加上n-1和n-2中较小的值的累加，达到缓存的效果
         */
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[cost.length-1],cost[cost.length-2]);
    }

}
