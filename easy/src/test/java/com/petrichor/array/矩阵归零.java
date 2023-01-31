package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 13:44 2023/1/31
 */

import org.junit.Test;

import java.util.HashSet;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * 输出：[[1,0,1],
 * [0,0,0],
 * [1,0,1]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]]
 * 输出：[[0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 */

public class 矩阵归零 {

    @Test
    public void main() {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes2(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(j); //行
                    col.add(i); //列
                }
            }
        }

        row.forEach(v -> {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][v] = 0;
            }
        });

        col.forEach(v -> {
            for (int i = 0; i < matrix[v].length; i++) {
                matrix[v][i] = 0;
            }
        });

    }

    public void setZeroes2(int[][] matrix) {     //暴力法：行和列多次重复置0，
        //判断第一行第一列是否有0                    //优化后：第一行第一列作为标记，大幅度减少重复置0次数
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;

        //判断第一行是否有0
        for (int i = 0; i < rowLen; i++) {
            if (matrix[i][0] == 0) {
                row0_flag = true;
            }
        }
        //判断第一列是否有0
        for (int i = 0; i < colLen; i++) {
            if (matrix[0][i] == 0) {
                col0_flag = true;
            }
        }

        //在第一排第一列标记
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //第一行或列为0的的列和行置0
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][0]==0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }


        if (row0_flag) {
            for (int i = 0; i < rowLen; i++) {
                matrix[i][0] = 0;
            }
        }

        if (col0_flag) {
            for (int i = 0; i < colLen; i++) {
                matrix[0][i] = 0;
            }
        }
    }

}
