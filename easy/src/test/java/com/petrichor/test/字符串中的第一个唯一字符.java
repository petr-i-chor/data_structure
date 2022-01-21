package com.petrichor.test;

import org.junit.Test;

import java.util.*;

/**
 * @Author jh
 * @Description
 * @Date created in 15:56 2022/1/14
 */
public class 字符串中的第一个唯一字符 {

    /**
     * @author: jh
     * @description:给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * s = "leetcode"
     * 返回 0
     * <p>
     * s = "loveleetcode"
     * 返回 2
     *  
     * <p>
     * 提示：你可以假定该字符串只包含小写字母。
     * <p>
     * @params:
     * @return:
     */

    @Test
    public void main() {
        String s = "loveleetcode";
        int i = firstUniqChar3(s);
        System.out.println(i);
    }

    public int firstUniqChar(String s) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        String next;
        while (iterator.hasNext()) {
            if (map.get(next = iterator.next()) == 1) {
                return s.indexOf(next);
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c))
                return i;
        }
        return -1;
    }

    public int firstUniqChar3(String s) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, 0);
            }
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry:set) {
            if (entry.getValue() == 0){
                return s.indexOf(entry.getKey());
            }

        }

        return -1;
    }

}
