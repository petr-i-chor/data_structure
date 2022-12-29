package com.petrichor.array;

import org.junit.Test;

import java.util.List;

/**
 * @Author jh
 * @Description
 * @Date created in 15:19 2022/12/23
 */
public class 寻找最长回文子串 {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * <p>
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * https://leetcode.cn/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
     */

    @Test
    public void test() {
        System.out.println(longestPalindrome("cbbxaaxbwbxaaxb"));
    }

    public String longestPalindrome(String s) {
        //中间扩散  //遍历节点
        /**
         * 两种情况
         * 1 以节点作为支点，向两边扩散（奇）
         * 2 以节点以及节点右边两边为支点，向两边扩散（偶）
         */

        if (s.length()==1)
            return s;

        String tmp = s.substring(0,1);
        for (int i = 0; i < s.length() - 1; i++) {
            //以节点作为支点
            String palindrome = getPalindrome(s, i, i);
            if (palindrome.length()>tmp.length()){
                tmp = palindrome;
            }

            //以节点及其右节点
            String palindrome1 = getPalindrome(s, i, i + 1);
            if (palindrome1.length()>tmp.length()){
                tmp = palindrome1;
            }

        }

        return tmp;
    }

    /**
     * 返回左边索引和右边索引
     */
    public String getPalindrome(String s, int left, int right) {

        /**
         * 3种情况 ->
         *      1 a      s.substring(left+1,right) = a;  符合要求
         *      2 ac     s.substring(left+1,right) = ''; 不符合要求，但无所谓
         *      3 aa     s.substring(left+1,right) = aa; 符合要求
         */

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left+1,right);  //substring 是左闭右开的
    }

}
