package com.petrichor.hot100;

import org.junit.Test;

public class 不同路径 {

    @Test
    public void test() {

        System.out.println(uniquePaths(3, 7));

    }

    public int uniquePaths(int m, int n) {

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    res[i][j] = 1;
                } else if (i == 0) {
                    res[i][j] = res[i][j - 1];
                } else if (j == 0) {
                    res[i][j] = res[i - 1][j];
                } else
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }


        return res[m-1][n-1];
    }

}
