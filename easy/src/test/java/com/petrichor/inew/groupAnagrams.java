package com.petrichor.inew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> stringHashMap = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];

            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                count[c-'a'] = count[c-'a'] + 1;
            }
            String key = Arrays.toString(count);

            List<String> list = stringHashMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            stringHashMap.put(key, list);
        }

        return new ArrayList<>(stringHashMap.values());
    }

}
