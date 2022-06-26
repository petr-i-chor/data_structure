package com.petrichor.toof;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author jh
 * @Description
 * @Date created in 11:11 2022/1/25
 */
public class 青蛙跳台阶 {

    /**
     *
     * @author: jh
     * @description:一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     *
     * 输入：n = 0
     * 输出：1
     * 提示：
     *
     * 0 <= n <= 100
     *
     * @params:
     * @return:
     *
     */

    /**
     * 终止条件 n=1 return 1, n=2 return 2;
     * 循环条件 青蛙跳一个或跳两格
     * 变化参数 n
     */


    @Test
    public void main(){
        System.out.println(numWays(100));
    }

    public int numWays(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return cache(n,map);
    }

    public int cache(int n,HashMap<Integer, Integer> map){
        if (n==1 || n==0)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        int i = (cache(n - 1,map) + cache(n - 2,map))%1000000007; //相加的地方取余不影响结果
        map.put(n,i);
        return i;
    }
}
