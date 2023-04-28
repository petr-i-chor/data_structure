package com.petrichor.golden;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 10:13 2023/4/28
 */
public class 字符串轮转  {

    @Test
    public void main(){
        System.out.println(isFlipedString("aab","baa"));
    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length()!=s2.length())
            return false;

        String s = s1+s1;
        return s.contains(s2);
    }
}
