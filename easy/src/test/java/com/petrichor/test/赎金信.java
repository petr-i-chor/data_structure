package com.petrichor.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author jh
 * @Description
 * @Date created in 17:29 2022/1/17
 */
public class 赎金信 {

    /**
     * @author: jh
     * @description: 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     * <p>
     * 如果可以，返回 true ；否则返回 false 。
     * <p>
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：ransomNote = "a", magazine = "b"
     * 输出：false
     * 示例 2：
     * <p>
     * 输入：ransomNote = "aa", magazine = "ab"
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：ransomNote = "aa", magazine = "aab"
     * 输出：true
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= ransomNote.length, magazine.length <= 105
     * ransomNote 和 magazine 由小写英文字母组成
     * @params:
     * @return:
     */


    @Test
    public void main() {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)){
                if (map.get(c)==1)
                    map.remove(c);
                else
                    map.put(c,map.get(c)-1);
            }else
                return false;
        }
        return true;
    }
}
