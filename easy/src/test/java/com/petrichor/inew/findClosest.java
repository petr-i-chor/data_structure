package com.petrichor.inew;

import org.junit.Test;

public class findClosest {
    @Test
    public  void main() {
        String[] words = {"I","am","a","student","from","a","university","in","a","city"};
        System.out.println(findClosest(words, "in", "city"));
    }
    public  int findClosest(String[] words, String word1, String word2) {
        //当前位置
        int index = -1;
        //最小距离
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)||words[i].equals(word2)){
                if (index == -1 || words[i].equals(words[index])){
                    index = i;
                }else {
                    min = Math.min(min,i-index);
                    index = i;
                }
            }
        }
        return min;
    }
}
