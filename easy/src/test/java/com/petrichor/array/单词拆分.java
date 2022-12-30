package com.petrichor.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author jh
 * @Description
 * @Date created in 16:28 2022/12/23
 */
public class 单词拆分 {

    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     * <p>
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     * 示例 2：
     * <p>
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     *      注意，你可以重复使用字典中的单词。
     * 示例 3：
     * <p>
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 300
     * 1 <= wordDict.length <= 1000
     * 1 <= wordDict[i].length <= 20
     * s 和 wordDict[i] 仅有小写英文字母组成
     * wordDict 中的所有字符串 互不相同
     */
    @Test
    public void main(){
        String s = "abcd";
        List<String> list = Arrays.asList("a", "abc", "b", "cd");
        System.out.println(wordBreak2(s, list));
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s,wordDict,0);
    }


    public boolean wordBreakHelper(String s, List<String> dict, int start){

        /**
         * 递归
         * 用字典里的字符从左到右拼接字符，不满足 false
         *                满足 以当前拼接字符串再进行拼接
         * 跳出条件
         *          拼接字符串的起始点 > 字符串的长度  即存在满足要求的字符
         *          全部递归分支线都返回false;
         */
        if (start >= s.length())
            return true;


        for (String s1 : dict) {
            int length = s1.length();
            if (start+ length > s.length())
                continue;
            else {
                if (s1.equals(s.substring(start, start+length))){
                    if (wordBreakHelper(s,dict,start+length))
                        return true;
                }
            }
        }

        return false;

    }


    public boolean wordBreak2(String s, List<String> dict){

        /**
         * 动态规划
         * 标记字典和字符串相符合的点
         *  1001010001
         *  1001 表示索引0-2存在一个单词
         *  100101 表示索引0-4存在1到3个单词
         *  将所有可能得单词的最后一位进行标记，如果s.length索引是1，说明存在满足要求的字符 *注意是s.length而不是s.length-1
         */

        boolean[] booleans = new boolean[s.length()+1];//1的左边总会存在字典里的单词，当索引为s.length为1的时候，即表示存在单词满足字符串
        booleans[0]=true;   //初始化数组，需要把第一轮的所有单词过一遍进行初始化

        for (int i = 0; i < s.length(); i++) {
            if (!booleans[i]) //false 跳过本次循环，表示该索引不是某个单词的起始，
                continue;

            for (String s1 : dict) {
                int length = s1.length();
                int len = i + length;

                if (len >s.length())
                    continue;

                if (booleans[len])
                    continue;

                if (s1.equals(s.substring(i, len)))
                    booleans[len]=true;

            }

        }
        return booleans[s.length()];

    }





















}
