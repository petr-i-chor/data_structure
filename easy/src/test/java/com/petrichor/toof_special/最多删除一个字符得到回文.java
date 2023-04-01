package com.petrichor.toof_special;

import org.junit.Test;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * 示例 3:
 * <p>
 * 输入: s = "abc"
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 */
public class 最多删除一个字符得到回文 {
    @Test
    public void main() {
        String s = "abc";
        System.out.println(validPalindrome(s));
    }

    public boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;
        int count = 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                if (count == 1) {
                    int i = left + 1;
                    int j = right;
                    while (i < j) {
                        if (s.charAt(i) != s.charAt(j)) {
                            break;
                        }
                        i++;
                        j--;
                    }
                    if (i >= j) {
                        return true;
                    } else {
                        i = left;
                        j = right - 1;
                        while (i < j) {
                            if (s.charAt(i) != s.charAt(j)) {
                                return false;
                            }
                            i++;
                            j--;
                        }
                        return true;
                    }
                }
            }
            left++;
            right--;
        }
        return true;
    }
}
