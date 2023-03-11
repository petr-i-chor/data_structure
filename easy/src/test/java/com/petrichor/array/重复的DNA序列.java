package com.petrichor.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 重复的DNA序列 {

    /*
     * DNA序列由一系列核苷酸组成，缩写为'A','C','G'和'T'.。
     *
     * 例如，"ACGAATTCCG"是一个 DNA序列 。
     * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
     *
     * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的长度为10的序列(子字符串)。你可以按 任意顺序 返回答案。
     *
     * 示例 1：
     *
     * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * 输出：["AAAAACCCCC","CCCCCAAAAA"]
     * 示例 2：
     *
     * 输入：s = "AAAAAAAAAAAAA"
     * 输出：["AAAAAAAAAA"]
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 105
     * s[i]=='A'、'C'、'G'or'T'
     *
     */
    @Test
    public void test() {
        List<String> list = findRepeatedDnaSequences("AAAAAAAAAAA");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> list = new ArrayList<>();
        if (s.length() <= 10) {
            return list;
        }

        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        for (int i = 10; i <= s.length(); i++) {
            String s1 = s.substring(i - 10, i);
            if (set.contains(s1)) {
                res.add(s1);
            }else {
                set.add(s1);
            }
        }
        list.addAll(res);

        return list;
    }
}
