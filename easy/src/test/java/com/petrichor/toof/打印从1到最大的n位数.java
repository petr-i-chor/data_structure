package com.petrichor.toof;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 13:40 2022/1/25
 */
public class 打印从1到最大的n位数 {

    @Test
    public void main() {
        int[] result = printNumbers(2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }

    public int[] printNumbers(int n) {
        int length = 1;
        while (n-- > 0)
            length *= 10;
        int[] result = new int[length-1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
