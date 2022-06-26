package com.petrichor.basic;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author jh
 * @Description
 * @Date created in 15:28 2022/1/14
 */
public class 矩阵置零 {

    /**
     * @author: jh
     * @description:给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出：[[1,0,1],[0,0,0],[1,0,1]]
     * 示例 2：
     * <p>
     * <p>
     * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     *  
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[0].length
     * 1 <= m, n <= 200
     * -231 <= matrix[i][j] <= 231 - 1
     * <p>
     * @params:
     * @return:
     */


    @Test
    public void main() {
        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        HashSet<Integer> r = new HashSet<>();
        HashSet<Integer> c = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    r.add(i);c.add(j);
                }
            }
        }
        Iterator<Integer> iterator = r.iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            for (int i = 0; i < matrix[integer].length; i++) {
                matrix[integer][i] = 0;
            }
        }
        Iterator<Integer> iterator2 = c.iterator();
        while (iterator2.hasNext()){
            Integer integer = iterator2.next();
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][integer] = 0;
            }
        }

    }

}
