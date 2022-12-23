package com.petrichor.toof;

/**
 * @Author jh
 * @Description
 * @Date created in 13:57 2022/9/8
 */

import org.junit.Test;

import java.util.LinkedList;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */


public class 翻转单词顺序 {

    @Test
    public void main() {

//        String s = " ";
//        String s = "  hello world!  ";
        String s = "a good   example";
//        String s = "the sky is blue";
        System.out.println(reverseWords3(s));
    }

    public String reverseWords(String s) {
        if (s == null || "".equals(s))
            return s;

        LinkedList<String> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        int startIndex = 0;
        int endIndex = 0;
        boolean startFlag = false;
        boolean endFlag = false;
        if (chars[0] != ' ') {
            startIndex = 0;
            startFlag = true;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1 && chars[chars.length - 1] == ' ')
                break;

            if (i == chars.length - 1 && chars[chars.length - 1] != ' ') {
                endIndex = i;
                endFlag = true;
            } else {

                if (chars[i] == ' ' && chars[i + 1] != ' ') {
                    startIndex = i + 1;
                    startFlag = true;
                }
                if (chars[i] != ' ' && chars[i + 1] == ' ') {
                    endIndex = i;
                    endFlag = true;
                }
            }
            if (startFlag && endFlag) {
                String substring = s.substring(startIndex, endIndex + 1);
                list.push(substring);
                startFlag = false;
                endFlag = false;
            }
        }
        StringBuilder res = new StringBuilder();

        while (list.peek() != null) {
            res.append(list.pop() + " ");
        }
        if (res.length() == 0 || "".equals(res))
            return "";
        res.deleteCharAt(res.length() - 1);

        return res.toString();
    }

    public String reverseWords2(String s) {
        if (s == null || "".equals(s))
            return s;

        String res = "";
        char[] chars = s.toCharArray();
        int startIndex = 0;
        int endIndex = 0;
        boolean startFlag = false;
        boolean endFlag = false;
        if (chars[0] != ' ') {
            startIndex = 0;
            startFlag = true;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1 && chars[chars.length - 1] == ' ')
                break;

            if (i == chars.length - 1 && chars[chars.length - 1] != ' ') {
                endIndex = i;
                endFlag = true;
            } else {

                if (chars[i] == ' ' && chars[i + 1] != ' ') {
                    startIndex = i + 1;
                    startFlag = true;
                }
                if (chars[i] != ' ' && chars[i + 1] == ' ') {
                    endIndex = i;
                    endFlag = true;
                }
            }
            if (startFlag && endFlag) {
                String substring = s.substring(startIndex, endIndex + 1);
                res = substring + " " + res;
                startFlag = false;
                endFlag = false;
            }
        }

        if (res == null || res.length() == 0 || "".equals(res))
            return "";

        return res.substring(0, res.length() - 1);
    }

    public String reverseWords3(String s) {
        if (s == null || "".equals(s))
            return s;
        String[] res = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = res.length - 1; i >= 0; i--) {
            if ("".equals(res[i]))
                continue;
            builder.append(res[i] + " ");
        }
        return builder.toString().trim();
    }

}
