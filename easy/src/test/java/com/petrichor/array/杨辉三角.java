package com.petrichor.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jh
 * @Description
 * @Date created in 9:23 2023/2/27
 */

/*
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 */

public class 杨辉三角 {

    @Test
    public void main() {
        List<List<Integer>> generate = generate(2);
        for (List<Integer> integers : generate) {
            for (Integer integer : integers) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

    /*
    1
    1 1
    1 2 1
    1 3 3  1
    1 4 6  4  1
    1 5 10 10 5 1

     */

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i)
                        list.add(j, 1);
                    else {
                        list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                    }
                }
                res.add(list);
            }
        return res;
    }
}
