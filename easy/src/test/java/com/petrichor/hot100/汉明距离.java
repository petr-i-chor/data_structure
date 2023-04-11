package com.petrichor.hot100;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 18:47 2023/4/11
 */
public class 汉明距离 {

    @Test
    public void main(){
        System.out.println(hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        int res = x^y;
        return Integer.bitCount(res);
    }
}
