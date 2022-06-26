package com.petrichor.toof;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 17:19 2022/1/27
 */
public class 字符串的排列 {

    /**
     *
     * @author: jh
     * @description:输入一个字符串，打印出该字符串中字符的所有排列。
     *
     *  
     *
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     *
     *  
     *
     * 示例:
     *
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     *
     * @params:
     * @return:
     *
     */


    @Test
    public void main(){
        permutation("abc");
    }

    public String[] permutation(String s) {

        int length = factorial(s.length());
        String[] res = new String[length];

        return null;
    }

    public int factorial(int n){
        if (n==1) return 1;
        return n*factorial(n-1);
    }

}
