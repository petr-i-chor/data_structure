package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 17:21 2023/2/6
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */

public class 螺旋矩阵 {
    @Test
    public void main() {
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        for (Integer integer : spiralOrder(matrix)) {
            System.out.print(integer + "\t");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        /*
        1 5 9  13       1 4 7
        2 6 10 14       2 5 8
        3 7 11 15       3 6 9
        4 8 12 16
        */

        int right = matrix.length - 1;
        int below = matrix[0].length - 1;
        int left = 0;
        int top = 0;

        int count = 0;
        long round = Math.round(Math.min(right + 1, below + 1) / 2.0);

        while (count < round) {
            if (count + 1 < round || (matrix.length<matrix[0].length?matrix.length % 2 == 0:matrix[0].length % 2 == 0)) {

                for (int j = top; j < below; j++) {
                    res.add(matrix[left][j]);
                }
                for (int i = left; i < right; i++) {
                    res.add(matrix[i][below]);
                }
                for (int j = below; j > top; j--) {
                    res.add(matrix[right][j]);
                }
                for (int i = right; i > left; i--) {
                    res.add(matrix[i][top]);
                }

                right--;
                below--;
                top++;
                left++;

            } else {

                if (matrix.length <= matrix[0].length) {
                    if (matrix.length % 2 == 1) {
                        for (int i = top; i <= below; i++) {
                            res.add(matrix[left][i]);
                        }
                    }
                } else if (matrix[0].length % 2 == 1) {
                    for (int i = left; i <= right; i++) {
                        res.add(matrix[i][top]);
                    }
                }
            }
            count++;
        }
        return res;
    }

}
