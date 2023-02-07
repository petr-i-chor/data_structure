package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 15:19 2023/2/7
 */

import org.junit.Test;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */

public class 搜索二维矩阵 {

    @Test
    public void main() {
//        [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
        int[][] matrix = {{1},{3}};
        System.out.println(searchMatrix(matrix, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target)
            return false;

        //两次二分查找
        int i = binarySearchCol(matrix, target, 0, matrix.length - 1);
        if (matrix[i][0] == target)
            return true;
        return binarySearchRow(i, matrix, target, 0, matrix[0].length) == -1 ? false : true;
    }


//    1 2 4 5  1 2 3

    public int binarySearchCol(int[][] matrix, int target, int start, int end) {

        int mid = start + (end - start >> 1);

        if (start == end){
            if (start == 0){
                return start;
            }else {
                return target<matrix[start][0]?start-1:start;
            }
        }else if (start > end){
            return end;
        }

        if (matrix[mid][0] == target) {
            return mid;
        } else if (matrix[mid][0] < target) {
            return binarySearchCol(matrix, target, mid + 1, end);
        } else {
            return binarySearchCol(matrix, target, start, mid - 1);
        }

    }

    public int binarySearchRow(int col, int[][] matrix, int target, int start, int end) {

        if (matrix[col][matrix[col].length-1]<target)
            return -1;

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start >> 1);

        if (matrix[col][mid] == target) {
            return mid;
        } else if (matrix[col][mid] < target) {
            return binarySearchRow(col, matrix, target, mid + 1, end);
        } else {
            return binarySearchRow(col, matrix, target, start, mid - 1);
        }

    }


}
