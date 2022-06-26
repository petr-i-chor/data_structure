package com.petrichor.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jh
 * @Description
 * @Date created in 14:51 2022/1/14
 */
public class 杨辉三角 {

    /**
     * @author: jh
     * @description:给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * 示例 2:
     * <p>
     * 输入: numRows = 1
     * 输出: [[1]]
     * @params:
     * @return:
     */


    @Test
    public void main() {
        int numRows = 10;
        List<List<Integer>> lists = generate(numRows);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if (i == 0)
                list.add(1);
           else {
                List<Integer> integers;
                list.add(1);
                for (int j = 0; j < i-1 ; j++) {
                     integers = lists.get(i - 1);
                    list.add(integers.get(j)+integers.get(j+1));
                }
                list.add(1);
            }
            lists.add(list);
        }

        return lists;
    }
}
