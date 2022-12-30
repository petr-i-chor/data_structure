package com.petrichor.array;

import java.util.List;

/**
 * @Author jh
 * @Description
 * @Date created in 17:25 2022/12/30
 */
public class 单词接龙 {

    /**
     * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
     * <p>
     * 每一对相邻的单词只差一个字母。
     *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
     * sk == endWord
     * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
     * 输出：5
     * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
     * 示例 2：
     * <p>
     * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
     * 输出：0
     * 解释：endWord "cog" 不在字典中，所以无法进行转换。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= beginWord.length <= 10
     * endWord.length == beginWord.length
     * 1 <= wordList.length <= 5000
     * wordList[i].length == beginWord.length
     * beginWord、endWord 和 wordList[i] 由小写英文字母组成
     * beginWord != endWord
     * wordList 中的所有字符串 互不相同
     */

    /**
     *                     hit
     *                     hot
     *            dot              lot
     *       dog     lot        dot   log
     *    log  cog     log
     *               dog
     */


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }

    public int[] dps(String endWord, List<String> wordList, List<String> tmp,int[] result) {



        for (String s : wordList) {
            //判断是否存在于tmp
            if (tmp.contains(s))
                continue;


            //判断是否只有一个字母不同
            if (isSame(s, wordList.get(wordList.size() - 1)))
                tmp.add(s);

        }
    }

    public boolean isSame(String word, String end) {
        int time = 0;
        for (int i = 0; i < word.length(); i++) {
            if (!(word.charAt(i) == end.charAt(i))) {
                time++;
                if (time >= 2)
                    return false;
            }
        }
        return true;
    }
}
