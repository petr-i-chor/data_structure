package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 11:10 2023/1/31
 */

import org.junit.Test;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 示例 1：
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *  
 *
 * 提示：
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 */

public class 找出字符串中第一个匹配项的下标 {

    @Test
    public void main(){
        String haystack = "mississippi";
        String needle= "issip";
        System.out.println(strStr(haystack,needle));
    }
    public int strStr(String haystack, String needle) {
        int hIndex = 0;
        while (hIndex<=(haystack.length()-needle.length())){
            int nIndex = 0;
            if (haystack.charAt(hIndex) == needle.charAt(nIndex)){
                boolean flag = true;
                while (nIndex<needle.length()){
                    if (haystack.charAt(hIndex) != needle.charAt(nIndex)){
                        flag =false;
                        hIndex -= nIndex;
                        break;
                    }
                    nIndex++;
                    hIndex++;
                }
                if (flag){
                    return hIndex-needle.length();
                }
            }
            hIndex++;
        }

        return -1;
    }
}
