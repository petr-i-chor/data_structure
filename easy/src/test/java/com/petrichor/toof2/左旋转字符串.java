package com.petrichor.toof2;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 19:26 2023/4/17
 */
public class 左旋转字符串 {

    @Test
    public void main(){
       reverseLeftWords("asfsfwef",2);
    }
    public String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
}
