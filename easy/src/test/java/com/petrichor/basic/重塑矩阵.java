package com.petrichor.basic;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author jh
 * @Description
 * @Date created in 11:46 2022/1/14
 */
public class 重塑矩阵 {

    /**
     * @author: jh
     * @description:
     * @params: 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
     * <p>
     * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
     * <p>
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
     * <p>
     * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
     * 输出：[[1,2,3,4]]
     * 示例 2：
     * <p>
     * <p>
     * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
     * 输出：[[1,2],[3,4]]
     * @return:
     */
    @Test
    public void main() {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 4;
        int c = 1;
        int[][] ints = matrixReshape2(mat, r, c);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        LinkedList<Integer> list = new LinkedList<>();

        if (mat.length * mat[0].length != r * c) {
            return mat;
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                list.add(mat[i][j]);
            }
        }
        int[][] ints = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ints[i][j] = list.poll();
            }

        }
        return ints;
    }

    public int[][] matrixReshape2(int[][] mat, int r, int c) {

        int[][] ints = new int[r][c];

        int m = mat.length;
        int n = mat[0].length;
        int row = 0;
        int col = 0;

        if (m * n != r * c) {
            return mat;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row = (i * n + j) / c;
                col = (i * n + j) % c;
                ints[row][col] = mat[i][j];
            }
        }
        return ints;
    }


}
