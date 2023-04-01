package com.petrichor.toof_special;

import org.junit.Test;

/**
 * 剑指 Offer II 018. 有效的回文
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 本题中，将空字符串定义为有效的 回文串 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 * <p>
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 */
public class 有效的回文 {

    @Test
    public void main() {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public boolean isPalindrome(String s) {

        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int length = str.length();
        for (int i = 0; i < (length>>1); i++) {
            if (str.charAt(i) != str.charAt(length - i - 1))
                return false;
        }

        return true;
    }
}
