package com.petrichor.inew;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {

        private Map<String, Integer> map = new HashMap<>();

        public WordsFrequency(String[] book) {
            for (int i = 0; i < book.length; i++) {
                if (map.containsKey(book[i])) {
                    map.put(book[i], map.get(book[i]) + 1);
                } else {
                    map.put(book[i], 1);
                }
            }
        }

        public int get(String word) {
            return map.getOrDefault(word, 0);
        }
    }