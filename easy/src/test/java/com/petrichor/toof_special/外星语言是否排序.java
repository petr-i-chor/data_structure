package com.petrichor.toof_special;

import org.junit.Test;

import java.util.HashMap;

/**
 * 剑指 Offer II 034. 外星语言是否排序
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 * <p>
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 * <p>
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在 words[i] 和 order 中的所有字符都是英文小写字母。
 */
public class 外星语言是否排序 {

    @Test
    public void main() {
        String[] words = {"app","apple"};
        System.out.println(isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 1;
        for (char c : order.toCharArray()) {
            map.put(c,i++);
        }

        for (int i1 = 0; i1 < words.length-1; i1++) {
            String word1 = words[i1];
            String word2 = words[i1+1];

            int l1 = word1.length();
            int l2 = word2.length();

            if (l1>l2){
                boolean b = true;
                for (int j = 0; j < l2; j++) {
                    if (map.get(word1.charAt(j))>map.get(word2.charAt(j))){
                        return false;
                    }else if (map.get(word1.charAt(j))<map.get(word2.charAt(j))){
                        b=false;
                        break;
                    }
                }
                if(b){
                    return false;
                }
            }else if (l1<=l2){
                for (int j = 0; j < l1; j++) {
                    if (map.get(word1.charAt(j))>map.get(word2.charAt(j))){
                        return false;
                    }else if (map.get(word1.charAt(j))<map.get(word2.charAt(j))){
                        break;
                    }
                }
            }
        }


        return true;
    }
}
