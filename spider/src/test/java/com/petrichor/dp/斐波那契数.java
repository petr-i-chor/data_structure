package com.petrichor.dp;

/**
 * @Author jh
 * @Description
 * @Date created in 11:09 2023/2/13
 */

import org.junit.Test;

/**
 * 509. 斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 30
 */
public class 斐波那契数 {

    @Test
    public void main() {
        System.out.println(fib(5));
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int n1 = 0;
        int n2 = 1;
        int temp;

        for (int i = 2; i < n; i++) {
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }

        return n1 + n2;
    }

}
