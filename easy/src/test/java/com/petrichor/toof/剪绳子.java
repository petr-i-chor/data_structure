package com.petrichor.toof;

/**
 * @Author jh
 * @Description
 * @Date created in 17:07 2022/9/8
 */

import org.junit.Test;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 *
 * 2 <= n <= 58
 *
 */
public class 剪绳子 {

    /**
     * 10 = 1+9 (9=1+8 (8=1+7...)) (2+7 (7=2+5...) (3+6))
     * 10 = 2+8 (2+2+6...) ()
     * 10 = 3+7 (3+3+4)
     * 10 = 4+6
     */

    @Test
    public void main(){
        System.out.println(cuttingRope(10));
    }

    public int cuttingRope(int n) {
        if (n == 2)
            return 1;



        return 0;
    }
}
