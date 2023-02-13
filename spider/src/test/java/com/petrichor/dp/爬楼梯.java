package com.petrichor.dp;

/**
 * @Author jh
 * @Description
 * @Date created in 9:26 2023/2/13
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 45
 */
public class 爬楼梯 {

    @Test
    public void main() {
        System.out.println(climbStairs3(5));
    }

    public int climbStairs(int n) {
        int[] res = {0};
        dp(n, res);
        return res[0];
    }

    public void dp(int n, int[] count) {
        if (n == 1) {
            count[0] += 1;
            return;
        }
        if (n == 2) {
            count[0] += 2;
            return;
        }

        dp(n - 1, count);
        dp(n - 2, count);

    }

    public int climbStairs2(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return dp2(n, cache);
    }

    public int dp2(int n, HashMap<Integer, Integer> map) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int i1,i2;
        if (map.containsKey(n - 1)) {
            i1 = map.get(n - 1);
        } else {
            i1 = dp2(n - 1,map);
            map.put(n-1,i1);
        }

        if (map.containsKey(n - 2)) {
            i2 = map.get(n - 2);
        } else {
            i2 = dp2(n - 2,map);
            map.put(n-2,i2);
        }
        return i1 + i2;
    }

    public int climbStairs3(int n) {
        if (n<=2){
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        int temp;

        for (int i = 3; i < n; i++) {
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;

        }

        return n1+n2;
    }



/*                        1
            1                    2
        1         2          1       2
      1    2    1    2    1    2   1   2
    1  2  1 2  1 2   1   1 2   1   1
   1 2 1  1    1         1
   1
   */

}
