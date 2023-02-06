package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 16:03 2023/2/6
 */

import org.junit.Test;

import java.util.ArrayList;

/**
 * 125. 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 * <p>
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 * <p>
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 */
public class 验证回文串 {

    @Test
    public void main() {
        String s = " ";
        System.out.println(isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c>=48 && c<=57) ||(c>=97 && c<=122)){
                characters.add(c);
            }else if (c>=65 && c<=90){
                characters.add((char) (c+32));
            }
        }

        int left = 0;
        int right = characters.size()-1;

        for (int i = 0; i < Math.round(characters.size()/2.0); i++) {
            if (characters.get(left++)!=characters.get(right--)){
                return false;
            }
        }

        return true;
    }


}
