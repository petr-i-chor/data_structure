package com.petrichor.toof2;

/**
 * @Author jh
 * @Description
 * @Date created in 17:53 2023/5/4
 */
public class 青蛙跳台阶II {
    public int numWays(int n) {
        if (n==1||n==0){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int cur = 2;
        int pre = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = pre;
            pre = cur;
            cur = (cur+(tmp%1000000007))%1000000007;
        }
        return cur;
    }
}
