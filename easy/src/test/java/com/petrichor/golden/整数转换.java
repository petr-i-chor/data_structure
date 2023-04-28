package com.petrichor.golden;

/**
 * @Author jh
 * @Description
 * @Date created in 10:54 2023/4/28
 */
public class 整数转换 {
    public int convertInteger(int A, int B) {
        return Integer.bitCount(A^B);
    }

}
