package com.petrichor.array;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 11:41 2023/1/18
 */
public class 正则表达式匹配 {
    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：s = "aa", p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * <p>
     * 输入：s = "aa", p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3：
     * <p>
     * 输入：s = "ab", p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * <p>
     * Some examples:
     * isMatch("aa","a") return false                   c*a*b  aab          abc   abb*c
     * isMatch("aa","aa") return true                   c*      aab
     * isMatch("aaa","aa") return false                 a*      aab
     * isMatch("aa", "a*") return true                  b       b
     * isMatch("aa", ".*") return true
     * isMatch("ab", ".*") return true
     * isMatch("aab", "c*a*b") return true
     */

    @Test
    public void main() {
        System.out.println(isMatch("aa", "c*a*b*.."));
    }

    public boolean isMatch(String s, String p) {

        return true;
//        return isSame(s, 0, p, 0);
    }





























//
//    public boolean isSame(String s, int sIndex, String p, int pIndex) {
//
////        if (sIndex == s.length() && (p.length() == pIndex || (p.charAt(pIndex - 2) == s.charAt(sIndex - 1) && p.charAt(pIndex - 1) == '*')))
////            return true;
//        /**
//         * 出口 s.length() = sIndex
//         * 判断 s.charAt(sIndex-1) 是否和 p.substring(pIndex+1,p.length()) 正则匹配
//         */
//
//        if (pIndex >= p.length() && sIndex < s.length())
//            return false;
//
//        if (pIndex >= p.length() && sIndex == s.length())
//            return true;
//
//        if (pIndex < p.length() && sIndex == s.length()) {
//            while (p.length() > pIndex) {
//                //判断p剩余正则是否能匹配0个字符
//                if (pIndex + 1 < p.length()) {
//                    if (p.charAt(pIndex + 1) == '*') {
//                        pIndex += 2;
//                    } else {
//                        return false;
//                    }
//                } else
//                    return false;
//            }
//            return true;
//        }
//
//        char sC = s.charAt(sIndex);
//        char pC = p.charAt(pIndex);
//        if (p.length() == pIndex + 1 && s.length() == sIndex + 1) {
//            if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(sIndex) == '.')
//                return true;
//            else
//                return false;
//        } else if (p.length() == pIndex + 1 && s.length() > sIndex + 1)
//            return false;
//
//
//        char pC1 = p.charAt(pIndex + 1);
//        if (pC == '.' && pC1 == '*') {
//            //递归找到第一个字母
//            //回溯返回p索引
//            int codeIndex = findMostCloseCode(p, pIndex, 0, s.length() - sIndex - 1);
//            if (codeIndex == -1) {
//                return false;
//            } else if (codeIndex == p.length()) {
//                return true;
//            } else {
//                for (int i = sIndex; i < s.length(); i++) {
//                    if (s.charAt(i) == p.charAt(codeIndex))
//                        return isSame(s, i + 1, p, codeIndex + 1);
//                }
//            }
//
//        }
//
//        if (pC1 == '*') {
//            if (pC == sC) {
//                return isSame(s, ++sIndex, p, pIndex);
//            } else {
//                return isSame(s, sIndex, p, pIndex + 2);
//            }
//        } else {
//            if (pC == sC || pC == '.') {
//                return isSame(s, ++sIndex, p, ++pIndex);
//            } else {
//                return false;
//            }
//        }
//
//    }
//
//    private Boolean getCodeIndex(String s, int sIndex, String p, int pIndex, char pC, char pC1) {
//        if (pC == '.' && pC1 == '*') {
//            //递归找到第一个字母
//            //回溯返回p索引
//            int codeIndex = findMostCloseCode(p, pIndex, 0, s.length() - sIndex - 1);
//            if (codeIndex == -1) {
//                return false;
//            } else if (codeIndex == p.length()) {
//                return true;
//            } else {
//                for (int i = sIndex; i < s.length(); i++) {
//                    if (s.charAt(i) == p.charAt(codeIndex))
//                        return isSame(s, i + 1, p, codeIndex + 1);
//                }
//            }
//
//        }
//        return null;
//    }
//
//    /**
//     * @author: jh
//     * @description:
//     * @params: sRemainLen s的长度-s的当前索引-1
//     * @return:
//     */
//
//    int findMostCloseCode(String p, int pIndex, int count, int sRemainLen) {
//        if (pIndex >= p.length())
//            return pIndex;
//
//        if ('a' <= p.charAt(pIndex) && 'z' >= p.charAt(pIndex)) {
//            count++;
//            if (sRemainLen < count)
//                return -1;
//            else
//                return pIndex;
//        } else if (p.charAt(pIndex + 1) == '*') {
//            return findMostCloseCode(p, pIndex + 2, count, sRemainLen);
//        } else {
//            count++;
//            if (sRemainLen < count)
//                return -1;
//            else
//                return findMostCloseCode(p, pIndex + 1, count, sRemainLen);
//        }
//
//    }

}
