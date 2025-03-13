package com.petrichor.inew;

import org.junit.Test;

import java.util.Arrays;

public class maxAliveYear {

    @Test
    public void main() {
        int []birth = {1900, 1901, 1950};
        int []death = {1948, 1951, 2000};
        int res = maxAliveYear(birth, death);
        System.out.println(res);
    }

    public int maxAliveYear(int[] birth, int[] death) {
//        0     1    0    0    1    0    1    1
//        1900  1948 1950 1951 1952 1953 1954 1955
        Arrays.sort(birth);
        Arrays.sort(death);

        int l = 0;
        int r = 0;

        int cur = 0;
        int max = 0;
        int maxYear = 0;
        while (l != birth.length){

            if (birth[l]<=death[r]){
                cur++;
                if (max < cur) {
                    maxYear = birth[l];
                    max = cur;
                }
                l++;
            }else {
                r++;
                cur--;
            }
        }

        return maxYear;
    }

}
