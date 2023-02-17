package com.petrichor.array;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author jh
 * @Description
 * @Date created in 14:23 2023/2/17
 */

/*
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class 无重复字符的最长子串 {

    @Test
    public void main() {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {

        /**
         * 滑动窗口
         *
         */
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;

        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                //相同的key在left左边，更新坐标
                Integer index = map.get(s.charAt(right));
                if (index < left) {
                    map.put(s.charAt(right), right);
                    right++;
                } else {
                    //相同的key在left右边，重复，移动左指针
                    max = Math.max(max, right - left);
                    map.put(s.charAt(right), right);
                    left = index + 1;
                    right++;
                }
            } else {
                map.put(s.charAt(right), right);
                right++;
            }

        }
        return Math.max(max, right - left);

    }
}
