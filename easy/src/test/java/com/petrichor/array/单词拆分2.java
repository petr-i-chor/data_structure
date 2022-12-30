package com.petrichor.array;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author jh
 * @Description
 * @Date created in 11:41 2022/12/30
 */
public class 单词拆分2 {

    /**
     * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
     * <p>
     * 注意：词典中的同一个单词可能在分段中被重复使用多次。
     * <p>
     * 示例 1：
     * <p>
     * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
     * 输出:["cats and dog","cat sand dog"]
     * 示例 2：
     * <p>
     * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
     * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
     * 解释: 注意你可以重复使用字典中的单词。
     * 示例 3：
     * <p>
     * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * 输出:[]
     * 提示：
     * <p>
     * 1 <= s.length <= 20
     * 1 <= wordDict.length <= 1000
     * 1 <= wordDict[i].length <= 10
     * s 和 wordDict[i] 仅有小写英文字母组成
     * wordDict 中所有字符串都 不同
     */

    @Test
    public void main() {
//        List<String> list = Arrays.asList("cats", "dog", "sand", "and", "cat");
//        wordBreak("catsanddog",list);
        List<String> list = Arrays.asList("cats", "dog", "sand", "and", "cat", "ca", "ts");
        for (String res : wordBreak("catsanddog", list)) {
            System.out.println(res);
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        /**
         * 在单词拆分的基础上，使用动态规划记录每一个节点上的单词
         *
         *  c   0
         *  a   1
         *  t   2
         *  s   3   cat
         *  a   4   cats
         *  n   5
         *  d   6
         *  d   7   and,sand
         *  o   8
         *  g   9
         *      10  dog
         *
         */

        int len = s.length();
        ArrayList[] dp = new ArrayList[len + 1];
        dp[0] = new ArrayList();

        for (int i = 0; i < len; i++) {

            if (dp[i] == null)    //不是节点跳过
                continue;

            //初始化数组
            for (String word : wordDict) {
                int length = word.length();

                if (i + length > len)
                    continue;

                if (word.equals(s.substring(i, i + length))) {
                    if (dp[i + length] == null)
                        dp[i + length] = new ArrayList();
                    dp[i + length].add(word);
                }

            }
        }

        ArrayList<String> result = new ArrayList<>();

        if (dp[len] == null)
            return result;

        ArrayList<String> tmp = new ArrayList<>();
        dps(dp, result, len, tmp);

        return result;
    }

    public void dps(ArrayList<String>[] dp, List<String> result, int end, List<String> tmp) {
        /**
         * 递归，将大规模的问题转化成小规模的问题
         * 大规模，找到可以成功拼接字符串的单词
         * 小规模，根据单词长度，找到下一个能够拼接的单词进行拼接
         * 出口，下一个单词的索引不在[0，length)区间
         */
        if (end <= 0) {
            Collections.reverse(tmp);
            result.add(tmp.stream().collect(Collectors.joining(" ")));
            Collections.reverse(tmp);
        }


        //如果存在满足要求的单词，dp[length]肯定有值，故已倒序的方式拼接字符串
        //需要找出每次递归的值，该递归属于向下传递递归
        ArrayList<String> list = dp[end];
        /**
         *          dog
         *     and      sand
         *  cats  ts       cat
         *           ca
         *
         * 整个递归的过程  dog->sand->cat(出口,保存结果集进行操作) 回溯 dog->sand 回溯 dog 向下传值 dog->and->cats (出口,保存结果集进行操作) 回溯 dog->and 向下传值 dog->and->ts->ca (出口,保存结果集进行操作)
         */
        for (String s : list) {
            tmp.add(s);
            dps(dp, result, end - s.length(), tmp); //向下传递
            tmp.remove(tmp.size() - 1);  //回溯 (很关键),使结果回溯到分支时的tmp  //喵，太喵了
        }

    }


}
