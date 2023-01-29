package com.petrichor.array;

import org.junit.Test;

import java.util.*;

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

//      ["hot","dot","dog","lot","log","cog"]

//                          hit
//                       hot
//                dot                    lot
//           dog      lot              dot   log
//        log  cog   log            dog     dog cog
//      cog        dog           cog log   cog
//               cog
    @Test
    public void main() {

        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        HashSet<String> wordList = new HashSet<>(list);
        System.out.println(ladderLength("hit", "cog", wordList));

//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        System.out.println(ladderLength("hit", "cog", wordList));
//        List<String> wordList = Arrays.asList("hot", "dog");
//        System.out.println(ladderLength("hot", "dog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        ArrayList<String> tmp = new ArrayList<>();
        int[] result = new int[1];
        result[0] = 0;
        tmp.add(beginWord);
        dps(endWord, wordList, tmp, result);
        return result[0];
    }

    public void dps(String endWord, List<String> wordList, List<String> tmp, int[] result) {


        if (endWord.equals(tmp.get(tmp.size() - 1))) {
            if (result[0] == 0) {
                result[0] = tmp.size();
            } else if (tmp.size() < result[0]) {
                result[0] = tmp.size();
                return;
            }
        } else {
            if (result[0] != 0 && tmp.size() >= result[0]) {
                return;
            }
        }


        for (String s : wordList) {
            //判断是否存在于tmp
            if (tmp.contains(s))
                continue;

            //判断是否只有一个字母不同
            if (isSame(s, tmp.get(tmp.size() - 1))) {
                tmp.add(s);
                dps(endWord, wordList, tmp, result);
                tmp.remove(tmp.size() - 1);
            }
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

    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict.size() == 0)
            return 0;
        dict.add(end);
        LinkedList<String> wordQueue = new LinkedList<>();
        LinkedList<Integer> distanceQueue = new LinkedList<>();
        wordQueue.add(start);
        distanceQueue.add(1);
        //track the shortest path
        int result = Integer.MAX_VALUE;
        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();
            if (currWord.equals(end)) {
                result = Math.min(result, currDistance);
            }
            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                for (char c = 'a';c <= 'z';c++){
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);
                    if (dict.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance + 1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        if (result < Integer.MAX_VALUE)
            return result;
        else
            return 0;
    }

}
