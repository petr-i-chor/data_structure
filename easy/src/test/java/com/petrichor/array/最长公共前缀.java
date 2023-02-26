package com.petrichor.array;


import javafx.beans.binding.When;
import org.junit.Test;

import java.util.Arrays;

/*
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */

public class 最长公共前缀 {
    @Test
    public void main() {
        String[] matrix = {"aa"};
        System.out.println(longestCommonPrefix3(matrix));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        int index = 0;
        Integer integer = Arrays.stream(strs).map(v -> v.length()).min(Integer::compareTo).get();
        Arrays.stream(strs).map(v -> v.length()).min(Integer::compareTo).get();
        out:
        while (index < integer) {
            for (int i = 1; i < strs.length; i++) {
                if ("".equals(strs[i]) || "".equals(strs[i - 1]) || strs[i].charAt(index) != strs[i - 1].charAt(index)) {
                    break out;
                }
            }
            index++;
        }
        return strs[0].substring(0, index);
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 1)
            return strs[0];

        int index = Integer.MAX_VALUE;
        for (int i = 1; i < strs.length; i++) {
            String s1 = strs[i];
            String s2 = strs[i - 1];
            int counter = 0;
            while (counter < index) {
                if ("".equals(strs[i]) || "".equals(strs[i - 1])
                        || s1.length() == counter || s2.length() == counter
                        || s1.charAt(counter) != s2.charAt(counter)) {
                    break;
                }
                counter++;
            }
            index = Math.min(counter, index);
        }
        return strs[0].substring(0, index);
    }

    public String longestCommonPrefix3(String[] strs) {
        String s1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s2 = strs[i];
            while (!s2.startsWith(s1)) {
                if ("".equals(s1))
                    return "";
                s1 = s1.substring(0, s1.length() - 1);
            }
        }
        return s1;
    }
}
