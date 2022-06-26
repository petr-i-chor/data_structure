package com.petrichor.toof;

import org.junit.Test;


/**
 * @Author jh
 * @Description
 * @Date created in 15:53 2022/1/25
 */
public class 顺时针打印矩阵 {

    /**
     * @author: jh
     * @description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     * <p>
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= matrix.length <= 100
     * 0 <= matrix[i].length <= 100
     * @params:
     * @return:
     */

    /**
     * 1  2  3  4
     * 5  6  7  8
     * 9  10 11 12
     * 13 14 15 16
     */

    @Test
    public void main() {
//        int[] res = spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},{13, 14, 15, 16}});
        int[] res = spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + "\t");
        }
    }

    public int[] spiralOrder(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;

        int[] res = new int[col * row];
        int index = 0;

        //循环圈数
        for (int i = 0; i < (row > col ? col + 1 >> 1 : row + 1 >> 1); i++) { //最外圈开始,一次一圈
            //循环
            //向右
            for (int j = i; j < col - 1 - i; j++) {
                res[index++] = matrix[i][j];
            }
            //向下
            for (int j = i; j < row - 1 - i; j++) {
                res[index++] = matrix[j][col - i - 1];
            }
            //向左
            for (int j = col - 1 - i; j > i; j--) {
                res[index++] = matrix[row - i - 1][j];
            }
            //向上
            for (int j = row - 1 - i; j > i; j--) {
                res[index++] = matrix[j][i];
            }
        }
        return res;
    }
}
