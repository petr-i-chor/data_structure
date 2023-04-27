package com.petrichor.golden;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 10:42 2023/4/27
 */
public class 判断字符是否唯一 {

    @Test
    public void main(){
        System.out.println(isUnique("abc"));
    }

    /**
     * aba
     * a-> 0001   b->0010  compare->0000
     * a & compare = 0 (1零则零)  compare |= a = 0001(1一则一)
     * b & compare = 0 (1零则零)  compare |= a = 0011(1一则一)
     * a & compare = 1 (2一则一)   return false
     *
     */
    public boolean isUnique(String astr) {
        int compare = 0;
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            int bit = 1 << c-'a';
            if ((bit&compare)!=0)   //一0则0
                return false;
            compare |= bit;
        }
        return true;
    }

}
