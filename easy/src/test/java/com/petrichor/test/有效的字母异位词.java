package com.petrichor.test;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 17:55 2022/1/17
 */
public class 有效的字母异位词 {

    /**
     *
     * @author: jh
     * @description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     *  
     *
     * 提示:
     *
     * 1 <= s.length, t.length <= 5 * 104
     * s 和 t 仅包含小写字母
     *
     * @params:
     * @return:
     *
     */


    @Test
    public void main() {
        String s = "anagram";
        String t = "nagara";
        System.out.println(isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            ints[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i]!=0)
                return false;
        }
        return true;
    }
}
